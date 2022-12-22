package com.americar.ecommerceapi.service;

import com.americar.ecommerceapi.dto.OrderCreateDto;
import com.americar.ecommerceapi.entity.Order;

import java.util.Optional;

public interface IOrderService {
    public Order createOrder(OrderCreateDto order);

    public Optional<Order> findById(String id);
}
