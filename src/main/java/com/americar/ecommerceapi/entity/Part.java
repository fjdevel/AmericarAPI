package com.americar.ecommerceapi.entity;

import javax.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;


@Data
@Entity
@NoArgsConstructor
public class Part {
     @Id
    private String id;

    @Column()
    private String batch;
    
    @Column()
    private String brand;

    @Column()
    private String brandDescription;

    @Column()
    private String customerId;

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
    private String models;

    @Column()
    private Integer multiples;

    @Column()
    private Integer quantity;

    @Column()
    private String salesMode;

    @OneToMany(mappedBy = "part")
    private List<PartWarehouseData> warehousesData;

    @Column()
    private String shippingId;

    @Column
    private String warehouseId;

}
