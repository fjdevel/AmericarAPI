package com.americar.ecommerceapi.entity;

import javax.persistence.*;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@NoArgsConstructor
public class PersonalAccountsCategories {
     @Id
    private String id;

    private ClientTypeEnum clientType;

    @Column
    private String description;

    @Column
    private String documentType;
    @Column
    private TypeEnum type;
}
