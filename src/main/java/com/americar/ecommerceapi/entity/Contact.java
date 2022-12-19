package com.americar.ecommerceapi.entity;

import javax.persistence.*;import java.util.UUID;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@Entity
@NoArgsConstructor
public class Contact {
    @Id
  @GeneratedValue(generator = "UUID")
  private UUID id;

    @Column(nullable = true)
    private String comments;

    @Column(nullable = true)
    private String degree;

    @Column(nullable = true)
    private String email;

    @Column(nullable = true)
    private String name;

    @Column(nullable = true)
    private String telephone;

    @Column(nullable = true)
    private String telephoneTime;

    @ManyToOne
    private Customer customer;
}
