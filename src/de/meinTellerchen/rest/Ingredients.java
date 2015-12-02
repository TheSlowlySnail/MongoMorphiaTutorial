package de.meinTellerchen.rest;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Id;

@Embedded
public class Ingredients {
	private ObjectId uuid;
	private String name;
	private ProductionEnum productionEnum;

	/**
	 * @return the uuid
	 */
	public ObjectId getUuid() {
		return uuid;
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
	 * @return the productionEnum
	 */
	public ProductionEnum getProductionEnum() {
		return productionEnum;
	}
	/**
	 * @param productionEnum the productionEnum to set
	 */
	public void setProductionEnum(ProductionEnum productionEnum) {
		this.productionEnum = productionEnum;
	}
}
