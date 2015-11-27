package de.meinTellerchen.rest;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Id;

@Embedded
public class Ingredients {
	@Id private ObjectId uuid;
	String name;
	ProductionEnum productionEnum;
}
