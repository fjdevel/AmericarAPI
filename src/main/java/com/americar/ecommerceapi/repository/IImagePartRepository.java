package com.americar.ecommerceapi.repository;

import com.americar.ecommerceapi.entity.ImagePart;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IImagePartRepository extends JpaRepository<ImagePart,String> {
}
