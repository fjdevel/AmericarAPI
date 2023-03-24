package com.americar.ecommerceapi.entity;


import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@NoArgsConstructor
public class PartWarehouseData {
    private String id;
    

    private String availableDateHour;


    private String campaingDiscountGroup;


    private Integer deliveryHours;


    private Integer discount;


    private Date lastPurchaseDate;


    private Date lastSaleDate;


    private String location;


    private Double price;


    private Double priceWithTax;


    private Double retailPrice;


    private Integer stock;


    private Integer stockAvailable;


    private Integer totalDiscount;


    private Double totalPrice;


    private Double totalRetailPrice;


    private String urgentAvailableDateHour;


    private Integer urgentDeliveryHour;


    private Integer urgentDiscount;


    private Double urgentPrice;


    private Double urgentPriceWithTax;


    private Double urgentTotalDiscount;


    private Integer urgentTotalPrice;


    private Double urgentTotalRetailPrice;


    private String warehouseId;


    private String zoneId;

    private Part part;

    private PartOEM partOEM;

}
