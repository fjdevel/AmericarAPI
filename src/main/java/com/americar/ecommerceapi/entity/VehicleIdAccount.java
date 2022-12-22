package com.americar.ecommerceapi.entity;


import javax.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@Entity
@NoArgsConstructor
public class VehicleIdAccount {

    @Id
    private String vehicleAccount;

    @ManyToOne
    private Customer customer;
}
