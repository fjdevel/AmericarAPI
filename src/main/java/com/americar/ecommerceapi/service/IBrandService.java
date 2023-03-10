package com.americar.ecommerceapi.service;

import com.americar.ecommerceapi.entity.Brand;

import java.util.List;
import java.util.Optional;


public interface IBrandService {
    public List<Brand> findByDescription(String description);

    public Optional<Brand> findById(String id);
}
