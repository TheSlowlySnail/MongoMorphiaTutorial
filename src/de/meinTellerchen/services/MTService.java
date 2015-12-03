package de.meinTellerchen.services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import de.meinTellerchen.rest.MongoDBCon;


@Path("/getProduct")
@Produces(MediaType.APPLICATION_JSON)
public class MTService {
	
	MongoDBCon mdb = new MongoDBCon();
	String[] test = new String[2];
	
	@GET
	public Response getTest(){
		test[0] = "testischein";
		return Response.ok().entity(test[0]).build();
	}

}
