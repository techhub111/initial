package com.assignment.microservice.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.microservice.entity.Shop;
import com.assignment.microservice.model.ErrorResponse;
import com.assignment.microservice.model.GeocodeAPIException;
import com.assignment.microservice.model.GeocodeRequest;
import com.assignment.microservice.model.LatLng;
import com.assignment.microservice.repository.ShopRepository;
import com.assignment.microservice.service.RetailManagerService;

/*
 * This controller class provides methods for the following operations:
 * Create a shop (Shop will be recorded in in-memory DB H2)
 * Find the nearest shop
 * Get Shop details provided shop name
 */
@RestController
public class RetailManagerController {

	@Autowired
	private RetailManagerService retailManagerService;

	@Autowired
	private ShopRepository shopRepository;
	
	@RequestMapping(value = "${createShop}", method = RequestMethod.POST)
	public Shop create(@RequestBody GeocodeRequest geocodeRequest) {
		return retailManagerService.create(geocodeRequest);
	}
	
	@RequestMapping(value = "${findClosestShop}", method = RequestMethod.GET)
	public Shop getShopWithinMinimumDistance(@PathVariable BigDecimal latitude, @PathVariable BigDecimal longitude) {
		LatLng currentLocation = new LatLng(latitude, longitude);
		return retailManagerService.getShopWithinMinimumDistance(currentLocation, shopRepository.findAll());
	}
	
	@RequestMapping(value = "${findShopByName}", method = RequestMethod.GET)
	public Shop getShop(@PathVariable("shopName") String shopName) {
		return retailManagerService.getShop(shopName);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponse> exceptionHandler(Exception ex) {
		ErrorResponse error = new ErrorResponse();
		error.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		error.setMessage(ex.getMessage());
		return new ResponseEntity<ErrorResponse>(error, HttpStatus.OK);
	}
	
	@ExceptionHandler(GeocodeAPIException.class)
	public ResponseEntity<ErrorResponse> exceptionHandler(GeocodeAPIException ex) {
		ErrorResponse error = new ErrorResponse();
		error.setErrorCode(ex.getErrorCode());
		error.setMessage(ex.getErrorMessage());
		return new ResponseEntity<ErrorResponse>(error, HttpStatus.OK);
	}

}
