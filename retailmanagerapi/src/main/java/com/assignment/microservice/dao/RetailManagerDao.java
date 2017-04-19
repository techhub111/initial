package com.assignment.microservice.dao;

import com.assignment.microservice.entity.Shop;
import com.assignment.microservice.model.LatLng;

public interface RetailManagerDao {
	public Shop getShopWithinMinimumDistance(LatLng latLng);
	public Shop getShop(String shopName);
}
