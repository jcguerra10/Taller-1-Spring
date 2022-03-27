package com.taller1.demo.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.taller1.demo.model.prod.Productsubcategory;

@Repository
public interface ProductsubcategoryRepository extends CrudRepository<Productsubcategory, Integer> {

}
