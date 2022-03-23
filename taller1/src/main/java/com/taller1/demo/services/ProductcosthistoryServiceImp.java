package com.taller1.demo.services;

import java.util.Optional;

import com.taller1.demo.model.prod.Productcosthistory;
import com.taller1.demo.repositories.ProductcosthistoryRepository;

public class ProductcosthistoryServiceImp implements ProductcosthistoryService {

	private ProductcosthistoryRepository pchRepository;
	
	public ProductcosthistoryServiceImp(ProductcosthistoryRepository pchRepository) {
		this.pchRepository = pchRepository;
	}

	@Override
	public Productcosthistory saveProductcosthistory(Productcosthistory pch) {
		return pchRepository.save(pch);
	}

	@Override
	public Productcosthistory editProductcosthistory(Productcosthistory pch, Integer id) {
		Optional<Productcosthistory> optional = pchRepository.findById(id);
		Productcosthistory getOptional = optional.get();
		getOptional = pch;
		return pchRepository.save(getOptional);
	}

}