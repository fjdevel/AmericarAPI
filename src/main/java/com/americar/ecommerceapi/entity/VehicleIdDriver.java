package com.americar.ecommerceapi.entity;


import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
public class VehicleIdDriver {

    private String vehicleIdDriver;

    private Customer customer;
}
