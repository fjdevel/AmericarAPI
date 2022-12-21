package com.americar.ecommerceapi.entity;


import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class CodeShipping {
     @Id
    private String id;

    @Column(nullable = true)
    private String account;

    @Column(nullable = true)
    private String address;

    @Column(nullable = true)
    private String location;

    @Column(nullable = true)
    private String name;

    @Column(nullable = true)
    private String postalCode;

}
