package com.americar.ecommerceapi.service.impl;

import com.americar.ecommerceapi.dto.OrderCreateDto;
import com.americar.ecommerceapi.dto.OrderUpdateDto;
import com.americar.ecommerceapi.entity.Order;
import com.americar.ecommerceapi.repository.IOrderRepository;
import com.americar.ecommerceapi.service.IOrderService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class OrderService implements IOrderService {
    @Autowired
    IOrderRepository orderRepository;

    private final ModelMapper modelMapper;

    @Autowired
    public OrderService(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }


    @Override
    public Order createOrder(OrderCreateDto order) {
        Order ordercreate = new Order();
        String uuid = UUID.randomUUID().toString();
        modelMapper.map(order,ordercreate);
        ordercreate.setId(uuid);
        return orderRepository.save(ordercreate);
    }

    @Override
    public Optional<Order> findById(String id) {
        return orderRepository.findById(id);
    }

    @Override
    public void updateOrder(OrderUpdateDto updateOrder) {
        //orderRepository.updateOrder(updateOrder.getId(),updateOrder.getComments(),updateOrder.getDate(),updateOrder.getOrderItems())
    }
}
