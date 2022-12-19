package com.americar.ecommerceapi.dto;

import com.americar.ecommerceapi.entity.GenderEnum;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Convert;
import java.util.List;

@Data
@NoArgsConstructor
public class CustomerCreateDto {
    @JsonInclude()
    private String address;

    @JsonInclude()
    @Convert(converter=ConversorEnunToString.class)
    private SNEnum authorizesComplianceCont;

    @JsonInclude()
    @Convert(converter=ConversorEnunToString.class)
    private SNEnum authorizesMarketing;

    @JsonInclude()
    @Convert(converter=ConversorEnunToString.class)
    private SNEnum authorizesOffers;

    @JsonInclude()
    @Convert(converter=ConversorEnunToString.class)
    private SNEnum authorizesOthers;

    @JsonInclude()
    private Boolean authorizesProcessing;

    @JsonInclude()
    @Convert(converter=ConversorEnunToString.class)
    private SNEnum authorizesProfile;

    @JsonInclude()
    @Convert(converter=ConversorEnunToString.class)
    private SNEnum authorizesSurveys;

    @JsonInclude()
    private Boolean authorizesTransfer;

    @JsonInclude()
    @Convert(converter=ConversorEnunToString.class)
    private SNEnum authorizesUse;

    @JsonInclude()
    private String category;

    @JsonInclude()
    private String city;

    @JsonInclude()
    private Boolean confidential;

    @JsonInclude()
    private String country;

    @JsonInclude()
    private String currency;

    @JsonInclude()
    private String document;

    @JsonInclude()
    private String documentId;

    @JsonInclude()
    private String documentType;

    @JsonInclude()
    private String door;

    @JsonInclude()
    private String email;

    @JsonInclude()
    private String emailNotAvailable;

    @JsonInclude()
    private String fax;

    @JsonInclude()
    private String fiscalAddress;

    @JsonInclude()
    private String fiscalAddressNumber;

    @JsonInclude()
    private String fiscalCity;

    @JsonInclude()
    private String floor;

    @JsonInclude()
    private String fullName;

    @JsonInclude()
    private GenderEnum gender;

    @JsonInclude()
    private List<String> mobilePhoneNumber;

    @JsonInclude()
    private List<String> phoneNumber;

    @JsonInclude()
    private String postalCode;

    @JsonInclude()
    private String streetNumber;

    @JsonInclude()
    private String surname;

    @JsonInclude()
    private String surname2;

    @JsonInclude()
    private String title;

    @JsonInclude()
    private String webSite;
}
