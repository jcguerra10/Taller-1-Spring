package com.taller1.demo.repositories;

import org.springframework.data.repository.CrudRepository;

import com.taller1.demo.model.prod.Product;

public interface ProductRepository extends CrudRepository<Product, Integer> {

}
