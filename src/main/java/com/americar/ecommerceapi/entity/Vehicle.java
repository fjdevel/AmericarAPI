package com.americar.ecommerceapi.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;


@Data
@NoArgsConstructor
public class Vehicle {

    private String id;

    private String body;


    private String brand;


    private String colour;


    private String customerId;


    private String customerIdDriver;


    private String customerIdOwner;


    private String emissions;


    private Double engineCapacity;


    private Date lastVisitDate;


    private Integer mileage;


    private String modelName;


    private String modelYear;


    private String modelNumber;


    private String plateNumber;


    private Date plateNumberDate;


    private Integer power;


    private String productionDate;

    private RegistrationData registrationData;


    private String transmission;


    private String upholstery;


    private String vin;

    private List<WorkshopId> workshopId;
}
