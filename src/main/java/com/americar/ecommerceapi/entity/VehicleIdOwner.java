package com.americar.ecommerceapi.entity;


import javax.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@Entity
@NoArgsConstructor
public class VehicleIdOwner {

    @Id
    @GeneratedValue(generator = "UUID")
    private UUID vehicleIdOwner;

    @ManyToOne
    private Customer customer;
}
