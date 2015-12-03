package de.meinTellerchen.rest;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

public class MongoDBCon {

	/**
	 * @return the db
	 */
	public MongoDatabase getDb() {
		return db;
	}
	/**
	 * @param db the db to set
	 */
	public void setDb(MongoDatabase db) {
		this.db = db;
	}
	/**
	 * @return the collection
	 */
	public MongoCollection<Document> getCollection() {
		return collection;
	}
	/**
	 * @param collection the collection to set
	 */
	public void setCollection(MongoCollection<Document> collection) {
		this.collection = collection;
	}
	/**
	 * @return the cursor
	 */
	public MongoCursor<Document> getCursor() {
		return cursor;
	}
	/**
	 * @param cursor the cursor to set
	 */
	public void setCursor(MongoCursor<Document> cursor) {
		this.cursor = cursor;
	}
	/**
	 * @param mongoClient the mongoClient to set
	 */
	public void setMongoClient(MongoClient mongoClient) {
		this.mongoClient = mongoClient;
	}
	private MongoClient mongoClient = new MongoClient("localhost", 27017);
	MongoDatabase db = getMongoClient().getDatabase("helge");
	MongoCollection<Document> collection = db.getCollection("Products");
	MongoCursor<Document> cursor = collection.find().iterator();
	public MongoClient getMongoClient() {
		return mongoClient;
	}
	

}
