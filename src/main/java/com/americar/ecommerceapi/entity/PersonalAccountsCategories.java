package com.americar.ecommerceapi.entity;

import javax.persistence.*;
import java.util.UUID;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@NoArgsConstructor
public class PersonalAccountsCategories {
    @Id
  @GeneratedValue(generator = "UUID")
  private UUID id;

    private ClientTypeEnum clientType;

    @Column
    private String description;

    @Column
    private String documentType;
    @Column
    private TypeEnum type;
}
