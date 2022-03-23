package com.taller1.demo.mock;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.taller1.demo.model.prod.Location;
import com.taller1.demo.repositories.LocationRepository;
import com.taller1.demo.services.LocationServiceImp;

class LocationTest {

	@Mock
	private LocationRepository locationRepository;

	@InjectMocks
	private LocationServiceImp ls;

	private Location location0;
	private Optional<Location> location0op;
	
	private Location location1;


	@BeforeEach
	void setUp1() {
		MockitoAnnotations.openMocks(this);
		
		location0 = new Location();
		location0.setLocationid(1);
		location0.setName("locat");
		location0.setAvailability(new BigDecimal(2));
		location0.setCostrate(new BigDecimal(1));
	}

	@Test
	void testThatSaveAnProduct() {
		when(locationRepository.save(location0)).thenReturn(location0);
		assertNotNull(ls.saveLocation(location0));
	}
	
	@Test
	void testConstraints() {
		when(locationRepository.save(location0)).thenReturn(location0);
		Location testLoc = ls.saveLocation(location0);
		assertTrue(testLoc.getName().length() >= 5, "ConstraintName");
		assertTrue(testLoc.getAvailability().intValue() >= 1 && testLoc.getAvailability().intValue() <= 10, "ConstraintAvailability");
		assertTrue(testLoc.getCostrate().intValue() == 0 || testLoc.getCostrate().intValue() == 1, "ConstraintCostRate");
	}
	
	@BeforeEach
	void setUp2() {
		MockitoAnnotations.openMocks(this);
		
		location0op = Optional.of(location0);
		
		location1 = new Location();
		location1.setLocationid(1);
		location1.setName("admin");
		location1.setAvailability(new BigDecimal(3));
		location1.setCostrate(new BigDecimal(4));
	}
	
	@Test
	void testThatEditAnProduct() {
		when(locationRepository.findById(1)).thenReturn(location0op);
		when(locationRepository.save(location1)).thenReturn(location1);
		assertNotNull(ls.editLocation(location1, 1));
	}
	
	
	
}