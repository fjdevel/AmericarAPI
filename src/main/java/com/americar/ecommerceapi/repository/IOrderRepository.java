package com.americar.ecommerceapi.repository;

import com.americar.ecommerceapi.entity.Item;
import com.americar.ecommerceapi.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;


public interface IOrderRepository extends JpaRepository<Order,String> {



}
