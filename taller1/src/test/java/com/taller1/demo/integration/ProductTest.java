package com.taller1.demo.integration;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.taller1.demo.model.prod.Product;
import com.taller1.demo.model.prod.Productcategory;
import com.taller1.demo.model.prod.Productsubcategory;
import com.taller1.demo.repositories.ProductRepository;
import com.taller1.demo.services.ProductServiceImp;

class ProductTest {

	@Mock
	private ProductRepository productRepository;

	@InjectMocks
	private ProductServiceImp ps;

	private Product product0;
	private Optional<Product> product0op;

	private Product product1;

	@BeforeEach
	void setUp1() {
		MockitoAnnotations.openMocks(this);

		Productcategory pCategory = new Productcategory();
		Productsubcategory pSubCategory = new Productsubcategory();
		pSubCategory.setProductcategory(pCategory);
		product0 = new Product();
		product0.setProductsubcategory(pSubCategory);
		product0.setProductnumber("1");
		product0.setSellstartdate(Timestamp.valueOf("2022-03-12 10:30:04"));
		product0.setSellenddate(Timestamp.valueOf("2022-03-13 10:30:04")); //
		product0.setWeight(BigDecimal.valueOf(12));
		product0.setSize("1");
	}

	@Test
	void testThatSaveAnProduct() {
		when(productRepository.save(product0)).thenReturn(product0);
		assertNotNull(ps.saveProduct(product0));
	}


	@Test
	void testConstraints() {
		when(productRepository.save(product0)).thenReturn(product0);
		Product testLoc = ps.saveProduct(product0);
		assertNotNull(testLoc.getProductsubcategory());
		assertNotNull(testLoc.getProductsubcategory().getProductcategory());
		assertTrue(testLoc.getProductnumber().equals("1"));
		assertTrue(testLoc.getSellstartdate().compareTo(testLoc.getSellenddate()) < 0 , "Date");
		assertTrue(testLoc.getWeight().doubleValue() > 0);
		assertTrue(Double.parseDouble(testLoc.getSize()) > 0);
	}
	
	@BeforeEach
	void setUp2() {
		MockitoAnnotations.openMocks(this);
		
		product0op = Optional.of(product0);
		
		Productcategory pCategory = new Productcategory();
		Productsubcategory pSubCategory = new Productsubcategory();
		pSubCategory.setProductcategory(pCategory);
		product1 = new Product();
		product1.setProductsubcategory(pSubCategory);
		product1.setProductnumber("1");
		product1.setSellstartdate(Timestamp.valueOf("2022-03-12 10:30:04"));
		product1.setSellenddate(Timestamp.valueOf("2022-03-13 10:30:04")); //
		product1.setWeight(BigDecimal.valueOf(12));
		product1.setSize("1");
	}
	
	@Test
	void testThatEditAnProduct() {
		when(productRepository.findById(1)).thenReturn(product0op);
		when(productRepository.save(product1)).thenReturn(product1);
		assertNotNull(ps.editProduct(product1, 1));
	}
}
