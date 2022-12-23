package com.americar.ecommerceapi.entity;

import javax.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;


@Data
@Entity
@NoArgsConstructor
@Table(name = "orders")
public class Order {
     @Id
    private String id;

    @Column
    private String comments;

    @Column
    private String customerId;

    @Column()
    @Temporal(TemporalType.DATE)
    private Date date;


    @Column
    private String number;

    @Column()
    @OneToMany(mappedBy="order")
    private List<OrderItem> orderItems;

    @Column
    private String orderTypeId;

    @Column
    private String plateNumber;

    @Column
    private String sellerId;

    @Column
    private String shippingId;

    @Column
    private String vin;

    @Column
    private String warehouseId;

    @Column
    private String userDms;

    @Column
    private Boolean blockRoute;

    @Column
    private Boolean fullShipment;

    @Column
    private String route;
}
