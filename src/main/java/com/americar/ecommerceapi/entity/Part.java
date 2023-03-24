package com.americar.ecommerceapi.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;


@Data
@NoArgsConstructor
public class Part {
    private String id;

    private String batch;

    private String brand;

    private String brandDescription;

    private String customerId;

    private String description;

    private Date entryDate;

    private String family;

    private String familyDescription;


    private String key;


    private Double lastCostPrice;


    private String models;


    private Integer multiples;


    private Integer quantity;


    private String salesMode;

    private List<PartWarehouseData> warehousesData;


    private String shippingId;

    private String warehouseId;

}
