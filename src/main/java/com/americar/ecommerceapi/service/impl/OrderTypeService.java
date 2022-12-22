package com.americar.ecommerceapi.service.impl;

import com.americar.ecommerceapi.entity.OrderType;
import com.americar.ecommerceapi.repository.IOrderTypesRepository;
import com.americar.ecommerceapi.service.IOrderTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderTypeService implements IOrderTypeService {
    @Autowired
    IOrderTypesRepository orderTypesRepository;
    @Override
    public Page<OrderType> findAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return orderTypesRepository.findAll(pageable);
    }

    @Override
    public Optional<OrderType> findById(String id) {
        return orderTypesRepository.findById(id);
    }
}
