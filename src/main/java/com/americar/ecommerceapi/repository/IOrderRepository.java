package com.americar.ecommerceapi.repository;

import com.americar.ecommerceapi.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOrderRepository extends JpaRepository<Order,String> {

}
