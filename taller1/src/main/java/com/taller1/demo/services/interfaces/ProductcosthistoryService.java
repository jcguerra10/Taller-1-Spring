package com.taller1.demo.services.interfaces;

import com.taller1.demo.model.prod.Productcosthistory;
import com.taller1.demo.model.prod.ProductcosthistoryPK;

public interface ProductcosthistoryService {
    public Productcosthistory saveProductcosthistory(Productcosthistory pch);
    public Productcosthistory editProductcosthistory(Productcosthistory pch, ProductcosthistoryPK id);
}
