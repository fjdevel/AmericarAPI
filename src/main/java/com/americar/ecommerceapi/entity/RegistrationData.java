package com.americar.ecommerceapi.entity;


import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;



@Data
@NoArgsConstructor
public class RegistrationData {
    private String id;

    private Date creationDate;


    private Date creationTime;


    private Date registrationDate;

    private String registrationUser;


    private Vehicle vehicle;
}
