package com.americar.ecommerceapi.repository;

import com.americar.ecommerceapi.entity.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface IBrandRepository extends JpaRepository<Brand, UUID> {
    List<Brand> findBrandByDescription(String description);
}
