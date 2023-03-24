package com.americar.ecommerceapi.entity;


import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;


@Data
@NoArgsConstructor
public class Customer {
    private String id;

    private String address;

    private String authorizesComplianceCont;

    private Date authorizesDate;

    private String authorizesMarketing;

    private String authorizesOffers;

    private String authorizesOthers;

    private Boolean authorizesProcessing;

    private String authorizesProfile;

    private String authorizesSurveys;

    private Boolean authorizesTransfers;

    private String authorizesUse;

    private Boolean cancelled;

    private String category;

    private String city;

    private Boolean confidential;

    private List<Contact> contacts;

    private String country;

    private String currency;

    private String currencyDefault;

    private Boolean dataProtection1;

    private Boolean dataProtection2;

    private Boolean dataProtection3;

    private Boolean dataProtection4;

    private Boolean dataProtection5;

    private Boolean dataProtection6;

    private Boolean dataProtection7;

    private String document;

    private String documentId;

    private String documentType;

    private String door;

    private String email;

    private String emailNotAvailable;

    private String fax;

    private String fiscalAddress;

    private String fiscalAddressNumber;

    private String fiscalCity;

    private String floor;

    private String fullName;

    private GenderEnum gender;

    private Date maxDate;

    private Date minDate;

    private List<String> mobilePhoneNumber;

    private String name;

    private List<String> phoneNumber;

    private String postalCode;

    private String receptionistId;

    private Date registerDate;

    private String registerUser;

    private String street;

    private String streetNumber;

    private String surname;

    private String surname2;

    private String title;

    private String tradeName;


    private List<VehicleIdAccount> vehicleIdAccounts;


    private List<VehicleIdCustomer> vehicleIdCustomers;


    private List<VehicleIdDriver> vehicleIdDrivers;


    private List<VehicleIdOwner> vehicleIdOwners;

    private String webSite;

}
