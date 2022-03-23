package com.taller1.demo.services;

import java.util.Optional;

import com.taller1.demo.model.prod.Product;
import com.taller1.demo.repositories.ProductRepository;

public class ProductServiceImp implements ProductService {
	
	public ProductRepository productRepository;
	
	public ProductServiceImp(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}
	
	@Override
	public Product saveProduct(Product pro) {
		return productRepository.save(pro);		
	}

	@Override
	public Product editProduct(Product pro, Integer id) {
		Optional<Product> opPro = productRepository.findById(id);
		Product editPro = opPro.get();
		editPro = pro;
		return productRepository.save(editPro);
	}

}