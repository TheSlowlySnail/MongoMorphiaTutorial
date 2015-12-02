package de.meinTellerchen.rest;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

@Entity
public class Profil {
	@Id private ObjectId uuid;
	private String name;
	@Embedded
	private List<Intolerances> intoleranc = new ArrayList<Intolerances>();
	private String mail;
	private String password;
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
	 * @return the intoleranc
	 */
	public List<Intolerances> getIntoleranc() {
		return intoleranc;
	}
	/**
	 * @param intoleranc the intoleranc to set
	 */
	public void setIntoleranc(List<Intolerances> intoleranc) {
		this.intoleranc = intoleranc;
	}
	/**
	 * @return the mail
	 */
	public String getMail() {
		return mail;
	}
	/**
	 * @param mail the mail to set
	 */
	public void setMail(String mail) {
		this.mail = mail;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	

}
