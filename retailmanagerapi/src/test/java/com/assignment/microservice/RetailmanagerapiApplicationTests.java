package com.assignment.microservice;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.assignment.microservice.entity.Shop;
import com.assignment.microservice.model.GeocodeRequest;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@PropertySource("classpath:application.properties")  
public class RetailmanagerapiApplicationTests {
	
	@Autowired
    private TestRestTemplate restTemplate;
	
	@Test
    public void createShop1() {
		GeocodeRequest geocodeRequest = new GeocodeRequest();
		geocodeRequest.setShopName("Shopping Center MyZeil");
		geocodeRequest.setShopNumber("106");
		geocodeRequest.setPostalCode("60313");
        ResponseEntity<Shop> responseEntity = restTemplate.postForEntity("/shops", geocodeRequest, Shop.class);
        Shop shop = responseEntity.getBody();
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals("Shopping Center MyZeil", shop.getShopName());
    }
	
	@Test
    public void createShop2() {
		GeocodeRequest geocodeRequest = new GeocodeRequest();
		geocodeRequest.setShopName("One New Change");
		geocodeRequest.setShopNumber("1");
		geocodeRequest.setPostalCode("EC4M 9AF");
        ResponseEntity<Shop> responseEntity = restTemplate.postForEntity("/shops", geocodeRequest, Shop.class);
        Shop shop = responseEntity.getBody();
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals("One New Change", shop.getShopName());
    }
	
	@Test
    public void createShop3() {
		GeocodeRequest geocodeRequest = new GeocodeRequest();
		geocodeRequest.setShopName("Skyline Plaza Frankfurt");
		geocodeRequest.setShopNumber("6");
		geocodeRequest.setPostalCode("60327");
        ResponseEntity<Shop> responseEntity = restTemplate.postForEntity("/shops", geocodeRequest, Shop.class);
        Shop shop = responseEntity.getBody();
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals("Skyline Plaza Frankfurt", shop.getShopName());
    }
	
	@Test
    public void createShop4() {
		GeocodeRequest geocodeRequest = new GeocodeRequest();
		geocodeRequest.setShopName("Olympia-Einkaufszentrum");
		geocodeRequest.setShopNumber("68");
		geocodeRequest.setPostalCode("80993");
        ResponseEntity<Shop> responseEntity = restTemplate.postForEntity("/shops", geocodeRequest, Shop.class);
        Shop shop = responseEntity.getBody();
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals("Olympia-Einkaufszentrum", shop.getShopName());
    }
	
	@Test
    public void createShop5() {
		GeocodeRequest geocodeRequest = new GeocodeRequest();
		geocodeRequest.setShopName("Burlington Arcade");
		geocodeRequest.setShopNumber("51");
		geocodeRequest.setPostalCode("W1J 0QJ");
        ResponseEntity<Shop> responseEntity = restTemplate.postForEntity("/shops", geocodeRequest, Shop.class);
        Shop shop = responseEntity.getBody();
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals("Burlington Arcade", shop.getShopName());
    }
	
	@Test
    public void createShop6() {
		GeocodeRequest geocodeRequest = new GeocodeRequest();
		geocodeRequest.setShopName("Alexa");
		geocodeRequest.setShopNumber("20");
		geocodeRequest.setPostalCode("10179");
        ResponseEntity<Shop> responseEntity = restTemplate.postForEntity("/shops", geocodeRequest, Shop.class);
        Shop shop = responseEntity.getBody();
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals("Alexa", shop.getShopName());
    }
	
	@Test
	public void getShop1() {
		assertEquals(restTemplate.getForObject("/shops/Shopping Center MyZeil", Shop.class).getShopName(),
				"Shopping Center MyZeil");
	}
	
	@Test
	public void getShop2() {
		assertEquals(restTemplate.getForObject("/shops/One New Change", Shop.class).getShopName(),
				"One New Change");
	}
	
	@Test
	public void getShop3() {
		assertEquals(restTemplate.getForObject("/shops/Skyline Plaza Frankfurt", Shop.class).getShopName(),
				"Skyline Plaza Frankfurt");
	}
	
	@Test
	public void getShop4() {
		assertEquals(restTemplate.getForObject("/shops/Olympia-Einkaufszentrum", Shop.class).getShopName(),
				"Olympia-Einkaufszentrum");
	}
	
	@Test
	public void getShop5() {
		assertEquals(restTemplate.getForObject("/shops/Burlington Arcade", Shop.class).getShopName(),
				"Burlington Arcade");
	}
	
	@Test
	public void getShop6() {
		assertEquals(restTemplate.getForObject("/shops/Alexa", Shop.class).getShopName(),
				"Alexa");
	}
	
	@Test
	public void getClosestShopFromHeathrowAirportLondon() {
		assertEquals(restTemplate.getForObject("/closest/51.4700256/-0.4564842", Shop.class).getShopName(),
				"One New Change");
	}
	
	@Test
	public void getClosestShopFromTegelAirportBerlin() {
		assertEquals(restTemplate.getForObject("/closest/52.5580555556/13.2847222222", Shop.class).getShopName(),
				"Alexa");
	}
	
}


