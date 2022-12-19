package com.americar.ecommerceapi.service;

import com.americar.ecommerceapi.entity.Brand;

import java.util.List;

public interface IBrandService {
    public List<Brand> findByDescription(String description);
}
