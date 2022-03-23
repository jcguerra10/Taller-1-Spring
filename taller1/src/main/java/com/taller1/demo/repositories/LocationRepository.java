package com.taller1.demo.repositories;

import org.springframework.data.repository.CrudRepository;

import com.taller1.demo.model.prod.Location;

public interface LocationRepository extends CrudRepository<Location, Integer> {

}
