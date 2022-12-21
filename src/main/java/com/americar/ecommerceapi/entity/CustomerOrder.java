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

    @Column
    private String referenceCustomerOrder;

    @ManyToOne
    private OrderSupplier orderSupplier;
}
