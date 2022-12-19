package com.americar.ecommerceapi.entity;

import javax.persistence.*;import java.util.UUID;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
@Entity
public class PartReturns {
    @Id
  @GeneratedValue(generator = "UUID")
  private UUID id;

    @Column()
    private String part;

    @Column()
    private String partReturnType;

    @Column()
    private Integer quantity;
}
