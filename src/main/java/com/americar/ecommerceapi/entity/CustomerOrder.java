package com.americar.ecommerceapi.entity;


import javax.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@Entity
@NoArgsConstructor
public class CustomerOrder {
     @Id
    private String id;

    @Column
    private String item;

    @Column
    private Integer quantity;

    @ManyToOne(optional = true)
    @JoinColumn(nullable = true)
    private OrderSupplier orderSupplier;
}
