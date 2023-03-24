package com.americar.ecommerceapi.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;


@Data
@NoArgsConstructor
public class OrderSupplier {

    private String id;


    private String clientName;


    private String creationTime;


    private String customerAccount;

    private List<CustomerOrder> customerOrder;


    private Date date;


    private String dateOrder;


    private List<Item> items;


    private String numberOrder;


    private Boolean singleOrder;


    private String typeOrder;

    private String user;


    private String warehouseId;

}
