package com.americar.ecommerceapi.entity;

import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
public class OrderItem {
    private String id;
    

    private String availableDateHour;


    private String brand;


    private String deliveryHours;


    private Integer discount;


    private String partId;


    private Double price;


    private Integer quantity;


    private Double retailPrice;


    private Double totalDiscount;


    private Double totalPrice;


    private Double totalRetailPrice;

    private Order order;

}
