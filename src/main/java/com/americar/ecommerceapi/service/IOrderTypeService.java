package com.americar.ecommerceapi.service;

import com.americar.ecommerceapi.entity.OrderType;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface IOrderTypeService {
    public Page<OrderType> findAll(int page, int size);

    public Optional<OrderType> findById(String id);
}
