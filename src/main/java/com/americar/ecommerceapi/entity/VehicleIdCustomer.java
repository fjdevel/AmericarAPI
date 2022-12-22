package com.americar.ecommerceapi.entity;


import javax.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@Entity
@NoArgsConstructor
public class VehicleIdCustomer {
    @Id
    private String vehicleIdCostumer;

    @ManyToOne
    private Customer customer;
}
