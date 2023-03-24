package com.americar.ecommerceapi.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;


@Data
@NoArgsConstructor
public class Order {
    private String id;


    private String comments;


    private String customerId;

    private Date date;



    private String number;

    private List<OrderItem> orderItems;


    private String orderTypeId;


    private String plateNumber;


    private String sellerId;


    private String shippingId;


    private String vin;


    private String warehouseId;


    private String userDms;


    private Boolean blockRoute;


    private Boolean fullShipment;


    private String route;
}
