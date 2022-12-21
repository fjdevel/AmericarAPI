package com.americar.ecommerceapi.entity;


import javax.persistence.*;

import lombok.Data;
import lombok.NoArgsConstructor;




@Data
@Entity
@NoArgsConstructor
public class AuthorizesbyBrand {
     @Id
    private String id;

    @Column(nullable = true)
    private String authorizesBrand;

    @Column(nullable = true)
    private Boolean authorizesMarketing;

    @Column(nullable = true)
    private boolean authorizesOffers;

    @Column(nullable = true)
    private boolean authorizesOthers;

    @Column(nullable = true)
    private boolean authorizesProfile;

    @Column(nullable = true)
    private boolean authorizesUse;

}
