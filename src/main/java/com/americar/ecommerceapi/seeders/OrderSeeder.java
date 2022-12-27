package com.americar.ecommerceapi.seeders;

import com.americar.ecommerceapi.entity.Order;
import com.americar.ecommerceapi.repository.IOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

@Component
public class OrderSeeder implements CommandLineRunner {

    private IOrderRepository orderRepository;

    @Autowired
    public OrderSeeder(IOrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Order order1 = new Order();
        order1.setId(UUID.randomUUID().toString());
        order1.setComments("Comentarios del pedido 1");
        order1.setCustomerId("C1");
        order1.setDate(new Date());
        order1.setNumber("123");
        order1.setOrderTypeId("T1");
        order1.setPlateNumber("ABC123");
        order1.setSellerId("S1");
        order1.setShippingId("SH1");
        order1.setVin("123ABC");
        order1.setWarehouseId("W1");
        order1.setUserDms("U1");
        order1.setBlockRoute(false);
        order1.setFullShipment(true);
        order1.setRoute("Ruta 1");
        orderRepository.save(order1);
    }
}