package com.americar.ecommerceapi.dto;

import com.americar.ecommerceapi.entity.Item;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;
import java.util.List;



@Data
@NoArgsConstructor
public class OrderUpdateDto {
    @JsonInclude()
    @Id
    private String id;

    @JsonInclude()
    private String comments;

    @JsonInclude()
    private String customerId;

    @JsonInclude()
    private Date date;

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

    @JsonInclude()
    private Boolean blockRoute;

    @JsonInclude()
    private Boolean fullShipment;

    @JsonInclude()
    private String number;

    @JsonInclude()
    private String route;
}
