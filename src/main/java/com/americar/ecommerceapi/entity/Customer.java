package com.americar.ecommerceapi.entity;


import javax.persistence.*;import java.util.UUID;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.Mapping;

import java.util.Date;
import java.util.List;


@Data
@Entity
@NoArgsConstructor
public class Customer {
    @Id
    private String id;

    @Column()
    private String address;

    @Column()
    private String authorizesComplianceCont;

    @Column()
    @Temporal(TemporalType.DATE)
    private Date authorizesDate;

    @Column()
    private String authorizesMarketing;

    @Column()
    private String authorizesOffers;

    @Column()
    private String authorizesOthers;

    @Column()
    private Boolean authorizesProcessing;

    @Column()
    private String authorizesProfile;

    @Column()
    private String authorizesSurveys;

    @Column()
    private Boolean authorizesTransfers;

    @Column()
    private String authorizesUse;

    @Column()
    private Boolean cancelled;

    @Column()
    private String category;

    @Column()
    private String city;

    @Column()
    private Boolean confidential;

    @Column()
    @OneToMany(mappedBy="customer")
    private List<Contact> contacts;

    @Column()
    private String country;

    @Column()
    private String currency;

    @Column()
    private String currencyDefault;

    @Column()
    private Boolean dataProtection1;

    @Column()
    private Boolean dataProtection2;

    @Column()
    private Boolean dataProtection3;

    @Column()
    private Boolean dataProtection4;

    @Column()
    private Boolean dataProtection5;

    @Column()
    private Boolean dataProtection6;

    @Column()
    private Boolean dataProtection7;

    @Column()
    private String document;

    @Column()
    private String documentId;

    @Column()
    private String documentType;

    @Column()
    private String door;

    @Column()
    private String email;

    @Column()
    private String emailNotAvailable;

    @Column()
    private String fax;

    @Column()
    private String fiscalAddress;

    @Column()
    private String fiscalAddressNumber;

    @Column()
    private String fiscalCity;

    @Column()
    private String floor;

    @Column()
    private String fullName;

    @Column()
    @Enumerated(EnumType.STRING)
    private GenderEnum gender;

    @Column()
    @Temporal(TemporalType.DATE)
    private Date maxDate;

    @Column()
    @Temporal(TemporalType.DATE)
    private Date minDate;

    @Column()
    @ElementCollection
    private List<String> mobilePhoneNumber;

    @Column()
    private String name;

    @Column()
    @ElementCollection
    private List<String> phoneNumber;

    @Column()
    private String postalCode;

    @Column()
    private String receptionistId;

    @Column()
    @Temporal(TemporalType.DATE)
    private Date registerDate;

    @Column()
    private String registerUser;

    @Column()
    private String street;

    @Column()
    private String streetNumber;

    @Column()
    private String surname;

    @Column()
    private String surname2;

    @Column()
    private String title;

    @Column()
    private String tradeName;


    @OneToMany(mappedBy="customer")
    private List<VehicleIdAccount> vehicleIdAccounts;


    @OneToMany(mappedBy="customer")
    private List<VehicleIdCustomer> vehicleIdCustomers;


    @OneToMany(mappedBy="customer")
    private List<VehicleIdDriver> vehicleIdDrivers;


    @OneToMany(mappedBy="customer")
    private List<VehicleIdOwner> vehicleIdOwners;

    @Column()
    private String webSite;

}
