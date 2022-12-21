package com.americar.ecommerceapi.entity;

import javax.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@Entity
@NoArgsConstructor
public class OrderDeparture {
     @Id
    private String id;

    @Column()
    private String address;

    @Column()
    private Double amount;

    @Column()
    private String customerAccount;

    @Column()
    private String customerName;

    @Column()
    @Temporal(TemporalType.DATE)
    private Date deliveryDate;

    @Column()
    private String documentRef;

    @Column()
    private String locality;

    @Column()
    private String postalCode;

    @Column()
    private String route;

    @Column()
    private String shippingId;

    @Column()
    private String warehouseId;
}
