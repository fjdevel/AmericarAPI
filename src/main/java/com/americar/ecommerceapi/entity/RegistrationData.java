package com.americar.ecommerceapi.entity;

import javax.persistence.*;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;



@Data
@Entity
@NoArgsConstructor
public class RegistrationData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    @Column()
    @Temporal(TemporalType.DATE)
    private Date creationDate;

    @Column()
    @Temporal(TemporalType.DATE)
    private Date creationTime;

    @Column()
    @Temporal(TemporalType.DATE)
    private Date registrationDate;

    @Column
    private String registrationUser;

    @OneToOne
    private Vehicle vehicle;
}
