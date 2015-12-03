package de.meinTellerchen.rest;

import java.io.IOException;
import java.util.List;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.codehaus.jackson.map.ObjectMapper;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

@Path("/produkt/{produktName}/{barcode}")
public class ProductRestService {

	private static Datastore ds ; 
	
	 public ProductRestService() {
		ds = dataBaseConnection();
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response writeProductWithProperties(@PathParam("produktName") String produktName, @PathParam("barcode") String barcode,
			List<Ingredient> ingredients) {
	
		if(produktName == null){
			return Response.status(Status.BAD_REQUEST).entity("ProduktName wurde nicht übergeben").build();
		}
		if(barcode == null){
			return Response.status(Status.BAD_REQUEST).entity("Barcode wurde nicht übergeben").build();
		}
		if(barcode.length()==13){
			return Response.status(Status.BAD_REQUEST).entity("Es wurde kein Valider Barcode übergeben").build();
		}
		if(ingredients.isEmpty()){
			return Response.status(Status.BAD_REQUEST).entity("Es wurde kein Inhaltsstoff übergeben").build();
		}
		
		
		List<Ingredient>productIngredients = ingredients;
		
		Product product = new Product();
		product.setName(produktName);
		product.setBarcode(barcode);
		product.setIngredient(productIngredients);
		
		ObjectMapper MAPPER = new ObjectMapper();

		try {
			return Response.status(Status.ACCEPTED).entity(MAPPER.writeValueAsString(product)).build();
		} catch (IOException e) {
			return Response.status(Status.BAD_REQUEST).entity("{" + e + "}").build();
		}

	}
	
	
	public Datastore dataBaseConnection(){
		Morphia morphia = new Morphia();

	
		MongoDBCon mdb = new MongoDBCon();
		morphia.map(Product.class).map(Ingredient.class).map(Intolerances.class).map(Profil.class);
		 return  morphia.createDatastore(mdb.getMongoClient(), "helge");

	}

}
