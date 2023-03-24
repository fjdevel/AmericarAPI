package com.americar.ecommerceapi.entity;


import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
public class PartReturns {
    private String id;


    private String part;


    private String partReturnType;


    private Integer quantity;
}
