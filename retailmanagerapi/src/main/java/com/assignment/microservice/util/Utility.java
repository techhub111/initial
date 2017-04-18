package com.assignment.microservice.util;

import java.util.function.BiFunction;

import org.springframework.stereotype.Component;

import com.assignment.microservice.entity.Shop;
import com.assignment.microservice.model.GeocodeRequest;
import com.assignment.microservice.model.GeocodeResponse;
import com.assignment.microservice.model.LatLng;

@Component
public class Utility {
	
	/*
	 * This BiFunction takes two input parameters of type: GeocodeRequest and GeocodeResponse,
	 * and produces Shop.
	 */
	public static BiFunction<GeocodeRequest, GeocodeResponse, Shop> transformer = (geocodeRequest, geocodeResponse) -> {
		Shop shop = new Shop();
		shop.setShopName(geocodeRequest.getShopName());
		shop.setShopNumber(geocodeRequest.getShopNumber());
		shop.setPostalCode(geocodeRequest.getPostalCode());
		shop.setLatitude(geocodeResponse.getResults().get(0).getGeometry().getLocation().getLat());
		shop.setLongitude(geocodeResponse.getResults().get(0).getGeometry().getLocation().getLng());
		shop.setFormatted_address(geocodeResponse.getResults().get(0).getFormatted_address());
		shop.setPlace_id(geocodeResponse.getResults().get(0).getPlace_id());
		return shop;
	};
	
	/*
	 * distance method calculates distance between two locations.
	 */
	public static double distance(LatLng location1, LatLng location2) {
		double sec1 = Math.sin(location1.getLat().doubleValue()) * Math.sin(location2.getLat().doubleValue());
		double dlong = Math.abs(location1.getLng().doubleValue() - location2.getLng().doubleValue());
		double sec2 = Math.cos(location1.getLat().doubleValue()) * Math.cos(location2.getLat().doubleValue());
		double centralAngle = Math.acos(sec1 + sec2 * Math.cos(dlong));
		return centralAngle * 6378.1;
	}
	
	/*
	 * shopNameExists checks whether Shop of given Shop name exists or not.
	 */
	public static Shop shopNameExists(String shopName, Iterable<Shop> shops) {
		Shop existingShop = null;
		for (Shop shop : shops) {
			if (shopName.equals(shop.getShopName())) {
				existingShop = shop;
				break;
			}
		}
		return existingShop;
	}
	
}
