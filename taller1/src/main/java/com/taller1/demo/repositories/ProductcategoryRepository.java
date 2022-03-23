package com.taller1.demo.repositories;

import org.springframework.data.repository.CrudRepository;

import com.taller1.demo.model.prod.Productcategory;

public interface ProductcategoryRepository extends CrudRepository<Productcategory, Integer> {

}
