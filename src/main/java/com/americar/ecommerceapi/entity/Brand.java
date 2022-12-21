package com.americar.ecommerceapi.entity;


import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Brand {
    @Id
    private String id;

    @Column()
    private String description;
}
