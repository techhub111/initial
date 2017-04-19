package com.assignment.microservice.service;

import com.assignment.microservice.entity.Shop;
import com.assignment.microservice.model.GeocodeRequest;
import com.assignment.microservice.model.LatLng;

public interface RetailManagerService {
	public Shop create(GeocodeRequest geocodeRequest);
	public Shop getShop(String shopName);
	public Shop getShopWithinMinimumDistance(LatLng currentLocation);
}
