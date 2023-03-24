package com.americar.ecommerceapi.entity;


import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@NoArgsConstructor
public class Item {
    private String id;


    private String brand;


    private String commentsItem;
    private Date expectedArrivalDate;


    private String itemCanceled;


    private Integer ordered;


    private String purchasePrice;


    private Integer received;
//
//
//    private String referenceCustomerOrder;


    private Integer referenceInput;

//
//    private String referenceProviderOrder;

    private ItemOrder itemOrder;

    private OrderSupplier orderSupplierItem;
}
