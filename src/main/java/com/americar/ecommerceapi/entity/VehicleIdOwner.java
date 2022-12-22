package com.americar.ecommerceapi.entity;


import javax.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@Entity
@NoArgsConstructor
public class VehicleIdOwner {

    @Id
    private String vehicleIdOwner;

    @ManyToOne
    private Customer customer;
}
