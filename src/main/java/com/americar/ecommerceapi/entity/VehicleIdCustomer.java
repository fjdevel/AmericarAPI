package com.americar.ecommerceapi.entity;


import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
public class VehicleIdCustomer {

    private String vehicleIdCostumer;

    private Customer customer;
}
