package de.meinTellerchen.rest;

import java.util.ArrayList;
import java.util.List;

import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

@Entity
public class Product {
	@Id private String barcode;
	@Embedded
	private List<Ingredients> ingredient = new ArrayList<Ingredients>();
	@Embedded
	private List<Ingredients> feel = new ArrayList<Ingredients>();
	private String picture;
	private String brand;
	private String name;
	private String producer;
	
	/**
	 * @return the barcode
	 */
	public String getBarcode() {
		return barcode;
	}
	/**
	 * @param barcode the barcode to set
	 */
	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}
	/**
	 * @return the ingredient
	 */
	public List<Ingredients> getIngredient() {
		return ingredient;
	}
	/**
	 * @param ingredient the ingredient to set
	 */
	public void setIngredient(Ingredients... ingredient) {
		for (int i = 0; i < ingredient.length; i++) {
			
			this.ingredient.add(ingredient[i]);
		}
	}
	/**
	 * @return the feel
	 */
	public List<Ingredients> getFeel() {
		return feel;
	}
	/**
	 * @param feel the feel to set
	 */
	public void setFeel(Ingredients... feel) {
		for (int i = 0; i < feel.length; i++) {
			this.feel.add(feel[i]);
			
		}
	}
	/**
	 * @return the picture
	 */
	public String getPicture() {
		return picture;
	}
	/**
	 * @param picture the picture to set
	 */
	public void setPicture(String picture) {
		this.picture = picture;
	}
	/**
	 * @return the brand
	 */
	public String getBrand() {
		return brand;
	}
	/**
	 * @param brand the brand to set
	 */
	public void setBrand(String brand) {
		this.brand = brand;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the producer
	 */
	public String getProducer() {
		return producer;
	}
	/**
	 * @param producer the producer to set
	 */
	public void setProducer(String producer) {
		this.producer = producer;
	}

	

}
