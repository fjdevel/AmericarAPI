package com.americar.ecommerceapi.entity;

import javax.persistence.*;import java.util.UUID;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@Entity
@NoArgsConstructor
public class ReservedItem {

    @Id
  @GeneratedValue(generator = "UUID")
  private UUID id;

    private String brand;

    @Column()
    private String comments;

    @Column()
    private String cost;

    @Column()
    private String description;

    @Column()
    @Temporal(TemporalType.DATE)
    private Date expectedArrivalDate;

    @Column()
    private String famMarker;

    @Column()
    private String item;

    @Column()
    private Boolean itemCanceled;

    @Column()
    private String reservedOrders;

    @Column()
    private String reservedOrdersPending;

    @Column()
    private String reservedStock;

    @Column()
    private String status;

    @Column()
    private Double totalAmount;

    @ManyToOne
    private Reservation reservation;
}
