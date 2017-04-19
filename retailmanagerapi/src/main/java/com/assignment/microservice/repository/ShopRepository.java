package com.assignment.microservice.repository;

import org.springframework.data.repository.CrudRepository;

import com.assignment.microservice.entity.Shop;

public interface ShopRepository extends CrudRepository<Shop, String> {
}


