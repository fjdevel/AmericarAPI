package com.americar.ecommerceapi.entity;


import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
public class VehicleIdAccount {

    private String vehicleAccount;

    private Customer customer;
}
