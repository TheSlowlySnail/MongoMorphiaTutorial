package de.meinTellerchen.rest;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

public class MongoDBCon {

	private MongoClient mongoClient = new MongoClient("localhost", 27017);
	MongoDatabase db = getMongoClient().getDatabase("helge");
	MongoCollection<Document> collection = db.getCollection("adresses");
	MongoCursor<Document> cursor = collection.find().iterator();
	public MongoClient getMongoClient() {
		return mongoClient;
	}
	

}
