package com.americar.ecommerceapi.entity;

import javax.persistence.*;import java.util.UUID;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;


@Data
@Entity
@NoArgsConstructor
public class PartOEM {
    @Id
  @GeneratedValue(generator = "UUID")
  private UUID id;

    private String batch;

    @Column()
    private String brand;

    @Column()
    private String brandDescription;


    @Column()
    private String description;

    @Column()
    @Temporal(TemporalType.DATE)
    private Date entryDate;

    @Column()
    private String family;

    @Column()
    private String familyDescription;

    @Column()
    private String key;

    @Column()
    private Double lastCostPrice;

    @Column()
    private Integer multiples;

    @Column()
    private Integer quantity;

    @Column()
    private String salesMode;

    @OneToMany(mappedBy = "partOEM")
    private List<PartWarehouseData> warehousesData;

    @Column()
    private Double retailPrice;

    @Column()
    private Double retailpriceWithTax;
}
