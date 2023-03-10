package com.americar.ecommerceapi.service;

import com.americar.ecommerceapi.entity.ImagePart;

import java.util.Optional;

public interface IImagePartService {
    public Optional<ImagePart> findById(String id);
}
