package de.meinTellerchen.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.bson.Document;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;


import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCursor;

import de.meinTellerchen.rest.MongoDBCon;

@Path("/hello")
public class HelloService {

	@GET
	@Produces("text/html")
	public Response getDBCon() {
		MongoDBCon mdb = new MongoDBCon();
		List<String> names = new ArrayList<String>();
		//MongoCursor<Document> nameCursor = mdb.collection.find(new Document("name", "Ina")).iterator();
		int counter = 0;
		 Morphia morphia = new Morphia();

		// MongoClient mongo = new MongoClient();
		// morphia.map(Hotel.class).map(Address.class);
		 
		morphia.map(Product.class).map(Ingredients.class).map(Intolerances.class).map(Profil.class);
		Datastore ds = morphia.createDatastore(mdb.getMongoClient(), "helge");
		
		//Inhaltsstoffe
		Ingredients ingredientsSugar = new Ingredients();
		ingredientsSugar.setName("sugar");
		Ingredients ingredientsHazelnuts = new Ingredients();
		ingredientsHazelnuts.setName( "hazelnuts");
		
		Intolerances intolerances = new Intolerances();
		intolerances.setName("nut allergy");
		intolerances.setIngredient(ingredientsHazelnuts);
		//intolerances.setReasonEnum(vegan);
		/*
		ingredients.setName("Palm oil");
		ingredients.setName("low-fat cocoa");
		ingredients.setName("Skimmed milk powder");
		ingredients.setName("emulsifier lecithin");
		*/
		
		
		
		Product product = new Product();
		product.setBarcode("4008400401928");
		product.setName("Nutella");
		product.setBrand("Ferrero");
		product.setIngredient(ingredientsSugar,ingredientsHazelnuts);
		ds.save(product);
		
		
//		Hotel hotel = new Hotel();
//		hotel.setName("Holiday Hotel");
//		hotel.setStars(2);
//
//		Address address = new Address();
//		address.setStreet("Maichinger Strasse 51");
//		address.setCity("Magstadt");
//		address.setPostCode("71106");
//		address.setCountry("Deutschland");

		// set address
//		hotel.setAddress(address);
		
//		ds.save(hotel);
/*
		while (nameCursor.hasNext()) {
			names.add(nameCursor.next().getString("name"));
			counter++;

		}

		if (!names.isEmpty()) {
			return Response.status(Status.ACCEPTED).entity("<h1>" + names.get(0) + "</h1>").type(MediaType.TEXT_HTML)
					.build();
		} else {
			return Response.status(Status.INTERNAL_SERVER_ERROR).type(MediaType.TEXT_HTML)
					.entity("kein Name in der DB gefunden").build();
		}
		*/
		// return "<h1>" + names[0] + "</h1>";
		return null;

	}



}
