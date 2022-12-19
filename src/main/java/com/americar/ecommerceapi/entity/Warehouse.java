package com.americar.ecommerceapi.entity;

import javax.persistence.*;import java.util.UUID;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@Entity
@NoArgsConstructor
public class Warehouse {
    @Id
  @GeneratedValue(generator = "UUID")
  private UUID id;

    @Column
    private String accountingBrand;

    @Column
    private String address;

    @Column
    private String brand;

    @Column
    private String city;

    @Column
    private String comercialName;

    @Column
    private String companyId;

    @Column
    private String documentId;

    @Column
    private String email;

    @Column
    private String fax;

    @Column
    private String fullName;

    @Column
    private String name;

    @Column
    private String phoneNumber;
}
