package com.taller1.demo.services;

import java.util.Optional;

import org.springframework.transaction.annotation.Transactional;

import com.taller1.demo.model.prod.Productinventory;
import com.taller1.demo.repositories.LocationRepository;
import com.taller1.demo.repositories.ProductInventoryRepository;

public class ProductInventoryServiceImp implements ProductInventoryService {

	private ProductInventoryRepository proinRepository;
	private LocationRepository lr;
	
	public ProductInventoryServiceImp(ProductInventoryRepository proinRepository, LocationRepository lr) {
		this.proinRepository = proinRepository;
		this.lr = lr;
	}

	@Transactional
	@Override
	public Productinventory saveProductInventory(Productinventory proInventory) {
		if (proInventory == null) {
			throw new NullPointerException();
		}
		if (proInventory.getLocation() == null) 
			throw new NullPointerException();
		if (lr.existsById(proInventory.getLocation().getLocationid()))
			throw new NullPointerException();
		
		if (proInventory.getQuantity() < 0)
			throw new IllegalArgumentException();
		
		return proinRepository.save(proInventory);
	}

	@Transactional
	@Override
	public Productinventory editProductInventory(Productinventory proInventory, Integer id) {
		Optional<Productinventory> optional = proinRepository.findById(id);
		Productinventory getOptional = optional.get();
		getOptional = proInventory;
		return proinRepository.save(getOptional);
	}

}
