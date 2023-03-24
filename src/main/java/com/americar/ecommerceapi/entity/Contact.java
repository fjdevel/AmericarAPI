package com.americar.ecommerceapi.entity;


import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
public class Contact {
    private String id;

    private String comments;

    private String degree;

    private String email;

    private String name;

    private String telephone;

    private String telephoneTime;

    private Customer customer;
}
