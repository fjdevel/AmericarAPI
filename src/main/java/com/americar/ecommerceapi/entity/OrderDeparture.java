package com.americar.ecommerceapi.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@NoArgsConstructor
public class OrderDeparture {
    private String id;


    private String address;


    private Double amount;


    private String customerAccount;


    private String customerName;


    private Date deliveryDate;


    private String documentRef;


    private String locality;


    private String postalCode;


    private String route;


    private String shippingId;


    private String warehouseId;
}
