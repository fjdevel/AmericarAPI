package com.americar.ecommerceapi.entity;

import javax.persistence.*;import java.util.UUID;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@Entity
@NoArgsConstructor
public class PartWarehouseData {
    @Id
  @GeneratedValue(generator = "UUID")
  private UUID id;
    
    @Column()
    private String availableDateHour;

    @Column()
    private String campaingDiscountGroup;

    @Column()
    private Integer deliveryHours;

    @Column()
    private Integer discount;

    @Column()
    @Temporal(TemporalType.DATE)
    private Date lastPurchaseDate;

    @Column()
    @Temporal(TemporalType.DATE)
    private Date lastSaleDate;

    @Column()
    private String location;

    @Column()
    private Double price;

    @Column()
    private Double priceWithTax;

    @Column()
    private Double retailPrice;

    @Column()
    private Integer stock;

    @Column()
    private Integer stockAvailable;

    @Column()
    private Integer totalDiscount;

    @Column()
    private Double totalPrice;

    @Column()
    private Double totalRetailPrice;

    @Column()
    private String urgentAvailableDateHour;

    @Column()
    private Integer urgentDeliveryHour;

    @Column()
    private Integer urgentDiscount;

    @Column()
    private Double urgentPrice;

    @Column()
    private Double urgentPriceWithTax;

    @Column()
    private Double urgentTotalDiscount;

    @Column()
    private Integer urgentTotalPrice;

    @Column()
    private Double urgentTotalRetailPrice;

    @Column()
    private String warehouseId;

    @Column()
    private String zoneId;

    @ManyToOne
    private Part part;

    @ManyToOne
    private Part partOEM;

}
