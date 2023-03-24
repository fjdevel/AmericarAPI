package com.americar.ecommerceapi.entity;


import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
public class CustomerOrder {
    private String id;


    private String item;


    private Integer quantity;

    private OrderSupplier orderSupplier;
}
