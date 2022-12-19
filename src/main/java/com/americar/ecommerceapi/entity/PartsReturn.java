package com.americar.ecommerceapi.entity;

import javax.persistence.*;import java.util.UUID;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@Entity
@NoArgsConstructor
public class PartsReturn {
    @Id
  @GeneratedValue(generator = "UUID")
  private UUID id;

    @Column
    private String part;

    @Column
    private String partReturnType;

    @Column
    private Integer quantity;
}
