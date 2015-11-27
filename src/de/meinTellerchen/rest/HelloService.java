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
		MongoCursor<Document> nameCursor = mdb.collection.find(new Document("name", "Ina")).iterator();
		int counter = 0;
		 Morphia morphia = new Morphia();

		// MongoClient mongo = new MongoClient();
		morphia.map(Hotel.class).map(Address.class);
		Datastore ds = morphia.createDatastore(mdb.getMongoClient(), "helge");

		Hotel hotel = new Hotel();
		hotel.setName("My Hotel");
		hotel.setStars(4);

		Address address = new Address();
		address.setStreet("123 Some street");
		address.setCity("Some city");
		address.setPostCode("123 456");
		address.setCountry("Some country");

		// set address
		hotel.setAddress(address);
		
		ds.save(hotel);

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
		// return "<h1>" + names[0] + "</h1>";

	}



}
