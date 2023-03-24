package com.americar.ecommerceapi.entity;


import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class PersonalAccountsCategories {
    private String id;

    private ClientTypeEnum clientType;


    private String description;


    private String documentType;

    private TypeEnum type;
}
