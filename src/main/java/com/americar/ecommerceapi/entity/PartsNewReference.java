package com.americar.ecommerceapi.entity;

import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
public class PartsNewReference {
    private String id;

    private String brand;

    private String brandNew;

    private String partId;


    private String partIdNew;
}
