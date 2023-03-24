package com.americar.ecommerceapi.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@NoArgsConstructor
public class ReservedItem {

    private String id;

    private String brand;


    private String comments;


    private String cost;


    private String description;


    private Date expectedArrivalDate;


    private String famMarker;


    private String item;


    private Boolean itemCanceled;


    private String reservedOrders;


    private String reservedOrdersPending;


    private String reservedStock;


    private String status;


    private Double totalAmount;

    private Reservation reservation;
}
