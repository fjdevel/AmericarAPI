package com.americar.ecommerceapi.entity;



import lombok.Data;
import lombok.NoArgsConstructor;




@Data
@NoArgsConstructor
public class AuthorizesbyBrand {
    private String id;

    private String authorizesBrand;

    private Boolean authorizesMarketing;

    private boolean authorizesOffers;

    private boolean authorizesOthers;

    private boolean authorizesProfile;

    private boolean authorizesUse;

}
