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
//
//    @Column
//    private String referenceCustomerOrder;

    @Column
    private Integer referenceInput;

//    @Column
//    private String referenceProviderOrder;

    @ManyToOne(optional = true)
    @JoinColumn(name = "itemOrder_item_fk", nullable = true)
    private ItemOrder itemOrder;

    @ManyToOne(optional = true)
    @JoinColumn(name = "order_supplier_item_fk", nullable = true)
    private OrderSupplier orderSupplierItem;
}
