package com.americar.ecommerceapi.entity;

import javax.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;


@Data
@Entity
@NoArgsConstructor
public class OrderSupplier {
    @Id
    private String id;
    
    @Column()
    private String clientName;

    @Column()
    private String creationTime;

    @Column()
    private String customerAccount;

    @OneToMany(mappedBy="orderSupplier")
    private List<CustomerOrder> customerOrder;

    @Column()
    @Temporal(TemporalType.DATE)
    private Date date;

    @Column()
    private String dateOrder;


    @OneToMany(mappedBy="orderSupplier")
    private List<Item> items;

    @Column()
    private String numberOrder;

    @Column()
    @ElementCollection
    private List<String> referenceCustomerOrder;

    @Column()
    private Boolean singleOrder;

    @Column()
    private String typeOrder;

    @Column()
    private String user;

    @Column()
    private String warehouseId;

}
