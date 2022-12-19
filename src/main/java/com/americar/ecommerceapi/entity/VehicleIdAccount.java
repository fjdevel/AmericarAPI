package com.americar.ecommerceapi.entity;


import javax.persistence.*;import java.util.UUID;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@Entity
@NoArgsConstructor
public class VehicleIdAccount {

    @Id
    @GeneratedValue(generator = "UUID")
    private UUID vehicleAccount;

    @ManyToOne
    private Customer customer;
}
