package de.meinTellerchen.rest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.ws.rs.core.Response;

import org.apache.http.HttpStatus;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;



public class ProductRestServiceTest {

	private ObjectMapper MAPPER = new ObjectMapper();
	
	private Product generateProdukt(){
		String produktName = "ProduktName";
		String barcode = UUID.randomUUID().toString();
		
		Product produkt = new Product();
		
		produkt.setBarcode(barcode);
		produkt.setName(produktName);
	
		
		Ingredient schoko = new Ingredient();
		schoko.setName("Schokolade");
		schoko.setProductionEnum(ProductionEnum.bio);
		List<Ingredient>ingredients = new ArrayList<Ingredient>();
		ingredients.add(schoko);
		produkt.setIngredient(ingredients);
		return produkt;
	}
	
	
	@Test
	public void test001_insertProdukt_expect200() throws JsonGenerationException, JsonMappingException, UnsupportedEncodingException, IOException {
	
		Product produkt = generateProdukt();
		ProductRestService prService = new ProductRestService();
		
		Response response = prService.writeProductWithProperties(produkt.getName(), produkt.getBarcode(), produkt.getIngredient());
		assertNotNull(response);
		assertEquals(HttpStatus.SC_ACCEPTED, response.getStatus());
		Product produktResponse  =  MAPPER.readValue(response.getEntity().toString(), Product.class);
		assertEquals(produkt.getName(),produktResponse.getName());
		System.out.println("Response"+response.getEntity());

	}
	
	
	
	@Test
	public void test002_insertProdukt_expect400() throws JsonGenerationException, JsonMappingException, UnsupportedEncodingException, IOException {
	
		Product produkt = generateProdukt();
		ProductRestService prService = new ProductRestService();
		
		Response response = prService.writeProductWithProperties(produkt.getName(), null, produkt.getIngredient());
		assertNotNull(response);
		assertEquals(HttpStatus.SC_BAD_REQUEST, response.getStatus());
		System.out.println("Response"+response.getEntity());
	}
	
	
	
	

}
