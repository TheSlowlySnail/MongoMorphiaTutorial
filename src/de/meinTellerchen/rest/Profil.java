package de.meinTellerchen.rest;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

@Entity
public class Profil {
	@Id private ObjectId uuid;
	private String name;
	private List<Intolerances> intoleranc = new ArrayList<Intolerances>();
	private String mail;
	private String password;

}
