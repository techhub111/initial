package com.assignment.microservice.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.assignment.microservice.dao.RetailManagerDao;
import com.assignment.microservice.entity.Shop;
import com.assignment.microservice.model.LatLng;
import com.assignment.microservice.repository.ShopRepository;
import com.assignment.microservice.util.Utility;

@Component
public class RetailManagerDaoImpl implements RetailManagerDao{
	
	@Autowired
	private ShopRepository shopRepository;

	@Override
	public Shop getShopWithinMinimumDistance(LatLng clientPosition) {
		Iterable<Shop> shops = shopRepository.findAll();
		double minimumDistance = Double.MAX_VALUE;
		Shop closestShop = null;
		for (Shop shop : shops) {
			LatLng shopLatLng = new LatLng(shop.getLatitude(), shop.getLongitude());
			Double distance = Utility.distance(clientPosition, shopLatLng);
			if (distance < minimumDistance) {
				minimumDistance = distance;
				closestShop = shop;
			}
		}
		return closestShop;
	}

	@Override
	public Shop getShop(String shopName) {
		return shopRepository.findOne(shopName);
	}
	
}