package com.americar.ecommerceapi.service.impl;

import com.americar.ecommerceapi.entity.ImagePart;
import com.americar.ecommerceapi.repository.IImagePartRepository;
import com.americar.ecommerceapi.service.IImagePartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ImagePartService implements IImagePartService {
    @Autowired
    IImagePartRepository imagePartRepository;

    @Override
    public Optional<ImagePart> findById(String id) {
        return imagePartRepository.findById(id);
    }
}
