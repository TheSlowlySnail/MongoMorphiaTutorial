package de.meinTellerchen.rest;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Id;

@Embedded
public class Intolerances {
	@Id private ObjectId uuid;
	private String name;
	private int grad;
	List<Ingredients> ingredient = new ArrayList<Ingredients>();

}
