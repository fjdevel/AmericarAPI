package com.americar.ecommerceapi.entity;

import javax.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
@Entity
public class PartReturns {
     @Id
    private String id;

    @Column()
    private String part;

    @Column()
    private String partReturnType;

    @Column()
    private Integer quantity;
}
