package com.americar.ecommerceapi.entity;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
@AllArgsConstructor
public class CodeShipping {
    private String id;

    private String account;

    private String address;

    private String location;

    private String name;

    private String postalCode;

}
