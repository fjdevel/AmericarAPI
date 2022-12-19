package com.americar.ecommerceapi.entity;

import javax.persistence.*;import java.util.UUID;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@Entity
@NoArgsConstructor
public class OrderItem {
    @Id
  @GeneratedValue(generator = "UUID")
  private UUID id;
    
    @Column
    private String availableDateHour;

    @Column
    private String brand;

    @Column
    private String deliveryHours;

    @Column
    private Integer discount;

    @Column
    private String partId;

    @Column
    private Double price;

    @Column
    private Integer quantity;

    @Column
    private Double retailPrice;

    @Column
    private Double totalDiscount;

    @Column
    private Double totalPrice;

    @Column
    private Double totalRetailPrice;

    @ManyToOne
    private Order order;

}
