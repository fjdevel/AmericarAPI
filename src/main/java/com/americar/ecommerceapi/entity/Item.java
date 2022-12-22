package com.americar.ecommerceapi.entity;

import javax.persistence.*;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@Entity
@NoArgsConstructor
public class Item {
    @Id
    private String id;

    @Column
    private String brand;

    @Column
    private String commentsItem;

    @Column()
    @Temporal(TemporalType.DATE)
    private Date expectedArrivalDate;

    @Column
    private String itemCanceled;

    @Column
    private Integer ordered;

    @Column
    private String purchasePrice;

    @Column
    private Integer received;

    @Column
    private String referenceCustomerOrder;

    @Column
    private Integer referenceInput;

    @Column
    private String referenceProviderOrder;

    @ManyToOne
    private ItemOrder itemOrder;

    @ManyToOne
    private OrderSupplier orderSupplier;
}
