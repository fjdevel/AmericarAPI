package com.americar.ecommerceapi.entity;

import javax.persistence.*;import java.util.UUID;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;


@Data
@Entity
@NoArgsConstructor
public class Order {
    @Id
  @GeneratedValue(generator = "UUID")
  private UUID id;

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
    private List<OrderItem> orderItems = null;

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
}
