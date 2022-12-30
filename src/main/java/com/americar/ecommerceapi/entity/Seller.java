package com.americar.ecommerceapi.entity;

import javax.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@Entity
@NoArgsConstructor
public class Seller {
     @Id
    private String id;

    @Column
    private String account;

    @Column
    private String leavingDate;

    @Column
    private String entryDate;


    @Column
    private String name;
}
