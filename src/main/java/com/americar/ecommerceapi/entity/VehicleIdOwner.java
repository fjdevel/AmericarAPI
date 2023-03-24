package com.americar.ecommerceapi.entity;


import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
public class VehicleIdOwner {


    private String vehicleIdOwner;

    private Customer customer;
}
