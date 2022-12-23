package com.americar.ecommerceapi.entity;

import javax.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;


@Data
@Entity
@NoArgsConstructor
public class ItemOrder {
     @Id
    private String id;

    @Column
    private String clientName;

    @Column()
    @Temporal(TemporalType.DATE)
    private Date creationTime;

    @Column()
    @Temporal(TemporalType.DATE)
    private Date date;

    @Column()
    private String dateOrder;

    @OneToMany(mappedBy="itemOrder",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Item> orderItems;

    @Column()
    private String numCustomerOrder;

    @Column()
    private String typeOrder;

    @Column(name = "userid")
    private String user;

    @Column()
    private String warehouseId;
}
