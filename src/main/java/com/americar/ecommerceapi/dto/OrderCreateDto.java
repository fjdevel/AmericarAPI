package com.americar.ecommerceapi.dto;

import com.americar.ecommerceapi.entity.Item;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class OrderCreateDto {
    @JsonInclude()
    private String comments;

    @JsonInclude()
    private String customerId;

    @JsonInclude()
    private String date;

    @JsonInclude()
    private String number;

    @JsonInclude()
    private List<Item> orderItems;

    @JsonInclude()
    private String orderTypeId;

    @JsonInclude()
    private String plateNumber;

    @JsonInclude()
    private String sellerId;

    @JsonInclude()
    private String shippingId;

    @JsonInclude()
    private String vin;

    @JsonInclude()
    private String warehouseId;

    @JsonInclude()
    private String userDms;
}
