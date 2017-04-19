package com.assignment.microservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.RestTemplate;

import com.assignment.microservice.dao.RetailManagerDao;
import com.assignment.microservice.entity.Shop;
import com.assignment.microservice.model.GeocodeAPIException;
import com.assignment.microservice.model.GeocodeRequest;
import com.assignment.microservice.model.GeocodeResponse;
import com.assignment.microservice.model.GeocoderStatus;
import com.assignment.microservice.model.LatLng;
import com.assignment.microservice.repository.ShopRepository;
import com.assignment.microservice.service.RetailManagerService;
import com.assignment.microservice.util.Utility;

@Service
public class RetailManagerServiceImpl implements RetailManagerService{
	
	@Autowired
	private Environment environment;
	
	@Autowired
	private RetailManagerDao retailManagerDao;
	
	@Autowired
	private ShopRepository shopRepository;
	
	@Autowired
	private RestTemplate restTemplate;
	
	/*
	 * This method creates a Shop, if shop is not existing in in-memory DB H2 and enrich it with latitude, logitude, formatted address and place_id 
	 * information obtained from calling GeoCoding API.
	 * but if shop name is is already present, then it updates the same resource with information obtained from GeoCoding API call.
	 */
	@Override
	@Transactional
	public Shop create(GeocodeRequest geocodeRequest) {
		Shop existingShop = Utility.shopNameExists(geocodeRequest.getShopName(), shopRepository.findAll());
		if(null != existingShop)
		{
			if (!geocodeRequest.getShopNumber().equals(existingShop.getShopNumber()) || !geocodeRequest.getPostalCode().equals(existingShop.getPostalCode()))
			{
				String uri = Utility.ceateURI(geocodeRequest);
			    ResponseEntity<GeocodeResponse> response = restTemplate.getForEntity(uri, GeocodeResponse.class);
			    if (response.getBody().getStatus().value().equals(GeocoderStatus.OK.value()))
				{
					GeocodeResponse geocodeResponse = response.getBody();
					Shop shop = Utility.transformer.apply(geocodeRequest, geocodeResponse);
					return shopRepository.save(shop);
				}
			    if (response.getBody().getStatus().value().equals(GeocoderStatus.ZERO_RESULTS.value()))
			    {
			    	throw new GeocodeAPIException(response.getStatusCodeValue(), environment.getProperty("ZERO_RESULTS")); 
			    }
			    if (response.getBody().getStatus().value().equals(GeocoderStatus.OVER_QUERY_LIMIT.value()))
			    {
			    	throw new GeocodeAPIException(response.getStatusCodeValue(), environment.getProperty("OVER_QUERY_LIMIT")); 
			    }
			    if (response.getBody().getStatus().value().equals(GeocoderStatus.INVALID_REQUEST.value()))
			    {
			    	throw new GeocodeAPIException(response.getStatusCodeValue(), environment.getProperty("INVALID_REQUEST")); 
			    }
			    if (response.getBody().getStatus().value().equals(GeocoderStatus.UNKNOWN_ERROR.value()))
			    {
			    	throw new GeocodeAPIException(response.getStatusCodeValue(), environment.getProperty("UNKNOWN_ERROR")); 
			    }
			    if (response.getBody().getStatus().value().equals(GeocoderStatus.REQUEST_DENIED.value()))
			    {
			    	throw new GeocodeAPIException(response.getStatusCodeValue(), environment.getProperty("REQUEST_DENIED")); 
			    }
			    
				return existingShop;
			}
			
		}
	    String uri = Utility.ceateURI(geocodeRequest);
	    ResponseEntity<GeocodeResponse> response = restTemplate.getForEntity(uri, GeocodeResponse.class);
	    if (response.getBody().getStatus().value().equals(GeocoderStatus.OK.value()))
		{
			GeocodeResponse geocodeResponse = response.getBody();
			Shop shop = Utility.transformer.apply(geocodeRequest, geocodeResponse);
			return shopRepository.save(shop);
		}
	    if (response.getBody().getStatus().value().equals(GeocoderStatus.ZERO_RESULTS.value()))
	    {
	    	throw new GeocodeAPIException(response.getStatusCodeValue(), environment.getProperty("ZERO_RESULTS")); 
	    }
	    if (response.getBody().getStatus().value().equals(GeocoderStatus.OVER_QUERY_LIMIT.value()))
	    {
	    	throw new GeocodeAPIException(response.getStatusCodeValue(), environment.getProperty("OVER_QUERY_LIMIT")); 
	    }
	    if (response.getBody().getStatus().value().equals(GeocoderStatus.INVALID_REQUEST.value()))
	    {
	    	throw new GeocodeAPIException(response.getStatusCodeValue(), environment.getProperty("INVALID_REQUEST")); 
	    }
	    if (response.getBody().getStatus().value().equals(GeocoderStatus.UNKNOWN_ERROR.value()))
	    {
	    	throw new GeocodeAPIException(response.getStatusCodeValue(), environment.getProperty("UNKNOWN_ERROR")); 
	    }
	    if (response.getBody().getStatus().value().equals(GeocoderStatus.REQUEST_DENIED.value()))
	    {
	    	throw new GeocodeAPIException(response.getStatusCodeValue(), environment.getProperty("REQUEST_DENIED")); 
	    }
		return null;
	}
	
	/*
	 * This method will return Shop information, provided shop name.
	 */
	@Override
	@Transactional
	public Shop getShop(String shopName) {
		return retailManagerDao.getShop(shopName);
	}
	
	/*
	 * This method will find the closest shop, provided the current location.
	 */
	@Override
	@Transactional
	public Shop getShopWithinMinimumDistance(LatLng latLng) {
		return retailManagerDao.getShopWithinMinimumDistance(latLng);
	}
	
	
	/*
	 * Following is the controller level exception handling.
	 */
	
	@ExceptionHandler(value = NumberFormatException.class)
	public String nfeHandler(NumberFormatException e) {
		return e.getMessage();
	}

}
