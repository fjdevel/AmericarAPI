package com.americar.ecommerceapi.entity;

import javax.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@Entity
@NoArgsConstructor
public class PartsNewReference {
     @Id
    private String id;

    @Column
    private String brand;

    @Column
    private String brandNew;

    @Column
    private String partId;

    @Column
    private String partIdNew;
}
