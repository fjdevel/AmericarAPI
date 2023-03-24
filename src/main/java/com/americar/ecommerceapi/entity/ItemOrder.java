package com.americar.ecommerceapi.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;


@Data
@NoArgsConstructor
public class ItemOrder {
    private String id;


    private String clientName;


    private Date creationTime;


    private Date date;


    private String dateOrder;

    private List<Item> orderItems;


    private String numCustomerOrder;


    private String typeOrder;
    private String user;


    private String warehouseId;
}
