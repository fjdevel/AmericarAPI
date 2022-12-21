package com.americar.ecommerceapi.entity;

import javax.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;


@Data
@Entity
@NoArgsConstructor
public class Vehicle {

     @Id
    private String id;
    @Column
    private String body;

    @Column
    private String brand;

    @Column
    private String colour;

    @Column
    private String customerId;

    @Column
    private String customerIdDriver;

    @Column
    private String customerIdOwner;

    @Column
    private String emissions;

    @Column
    private Double engineCapacity;

    @Column()
    @Temporal(TemporalType.DATE)
    private Date lastVisitDate;

    @Column()
    private Integer mileage;

    @Column()
    private String modelName;

    @Column()
    private String modelYear;

    @Column()
    private String modelNumber;

    @Column()
    private String plateNumber;

    @Column()
    @Temporal(TemporalType.DATE)
    private Date plateNumberDate;

    @Column()
    private Integer power;

    @Column()
    private String productionDate;

    @OneToOne(mappedBy = "vehicle")
    private RegistrationData registrationData;

    @Column()
    private String transmission;

    @Column()
    private String upholstery;

    @Column()
    private String vin;

    @OneToMany(mappedBy = "vehicle")
    private List<WorkshopId> workshopId;
}
