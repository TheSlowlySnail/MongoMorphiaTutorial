package de.meinTellerchen.rest;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Id;

@Embedded
public class Intolerances {
	
	private ObjectId uuid;
	private String name;
	private int grad;
	ReasonEnum reasonEnum;
	/**
	 * @return the uuid
	 */
	public ObjectId getUuid() {
		return uuid;
	}
	List<Ingredient> ingredient = new ArrayList<Ingredient>();
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
	 * @return the grad
	 */
	public int getGrad() {
		return grad;
	}
	/**
	 * @param grad the grad to set
	 */
	public void setGrad(int grad) {
		this.grad = grad;
	}
	/**
	 * @return the ingredient
	 */
	public List<Ingredient> getIngredient() {
		return ingredient;
	}
	/**
	 * @param ingredient the ingredient to set
	 */
	public void setIngredient(Ingredient ingredient) {
		this.ingredient.add(ingredient);
	}
	/**
	 * @return the reasonEnum
	 */
	public ReasonEnum getReasonEnum() {
		return reasonEnum;
	}
	/**
	 * @param reasonEnum the reasonEnum to set
	 */
	public void setReasonEnum(ReasonEnum reasonEnum) {
		this.reasonEnum = reasonEnum;
	}

}
