package com.taller1.demo.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.taller1.demo.model.prod.Location;

@Repository
public interface LocationRepository extends CrudRepository<Location, Integer> {

}
