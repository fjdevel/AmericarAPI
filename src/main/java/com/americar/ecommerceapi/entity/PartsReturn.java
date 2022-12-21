package com.americar.ecommerceapi.entity;

import javax.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@Entity
@NoArgsConstructor
public class PartsReturn {
     @Id
    private String id;

    @Column
    private String part;

    @Column
    private String partReturnType;

    @Column
    private Integer quantity;
}
