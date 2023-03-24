package com.americar.ecommerceapi.dto;

import com.americar.ecommerceapi.entity.GenderEnum;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Convert;
import java.util.List;

@Data
@NoArgsConstructor
public class CustomerCreateDto {
    private String category;
    private String title;
    private String name;
    private String fullName;
    private String surname;
    private String surname2;
    private String documentId;
    private String gender;
    private String documentType;
    private String address;
    private String streetNumber;
    private String floor;
    private String door;
    private String postalCode;
    private String city;
    private String country;
    private String email;
    private String emailNotAvailable;
    private String fax;
    private String webSite;
    private String currency;
    private String phoneNumber;
    private List<String> mobilePhoneNumber;
    private boolean authorizesProcessing;
    private boolean authorizesTransfer;
    private boolean confidential;
    private boolean dataProtection1;
    private boolean dataProtection2;
    private boolean dataProtection3;
    private boolean dataProtection4;
    private boolean dataProtection5;
    private boolean dataProtection6;
    private boolean dataProtection7;
    private String authorizesUse;
    private String authorizesComplianceCont;
    private String authorizesMarketing;
    private String authorizesSurveys;
    private String authorizesProfile;
    private String authorizesOffers;
    private String authorizesOthers;
}
