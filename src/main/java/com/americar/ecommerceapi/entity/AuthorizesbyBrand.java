package com.americar.ecommerceapi.entity;


import javax.persistence.*;
import java.util.UUID;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;


@Data
@Entity
@NoArgsConstructor
public class AuthorizesbyBrand {
    @Id
  @GeneratedValue(generator = "UUID")
  private UUID id;

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
