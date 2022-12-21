package com.americar.ecommerceapi.entity;


import javax.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@Entity
@NoArgsConstructor
public class VehicleIdDriver {
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID vehicleIdDriver;

    @ManyToOne
    private Customer customer;
}
