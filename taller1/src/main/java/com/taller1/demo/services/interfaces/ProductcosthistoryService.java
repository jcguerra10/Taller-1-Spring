package com.taller1.demo.services.interfaces;

import com.taller1.demo.model.prod.Productcosthistory;

public interface ProductcosthistoryService {
    public Productcosthistory saveProductcosthistory(Productcosthistory pch);
    public Productcosthistory editProductcosthistory(Productcosthistory pch, Integer id);
}