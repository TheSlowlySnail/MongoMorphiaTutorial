package de.meinTellerchen.rest;

import java.util.ArrayList;
import java.util.List;

import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Entity;

@Entity
public class Product {
	private String barcode;
	@Embedded
	private List<Ingredients> ingredient = new ArrayList<Ingredients>();
	@Embedded
	private List<Ingredients> feel = new ArrayList<Ingredients>();
	private String picture;
	private String brand;
	private String name;
	private String producer;
	
	

}
