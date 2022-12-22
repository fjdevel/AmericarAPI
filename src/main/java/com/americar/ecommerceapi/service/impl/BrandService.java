package com.americar.ecommerceapi.service.impl;

import com.americar.ecommerceapi.entity.Brand;
import com.americar.ecommerceapi.repository.IBrandRepository;
import com.americar.ecommerceapi.service.IBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class BrandService implements IBrandService {

    @Autowired
    IBrandRepository brandRepository;

    public List<Brand> findByDescription(String description) {
        return brandRepository.findBrandByDescription(description);
    }

    public Optional<Brand> findById(String id){
        return brandRepository.findById(id);
    }

}
