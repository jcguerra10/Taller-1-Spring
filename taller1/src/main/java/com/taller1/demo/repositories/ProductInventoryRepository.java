package com.taller1.demo.repositories;

import org.springframework.data.repository.CrudRepository;

import com.taller1.demo.model.prod.Productinventory;

public interface ProductInventoryRepository extends CrudRepository<Productinventory, Integer> {
	
}