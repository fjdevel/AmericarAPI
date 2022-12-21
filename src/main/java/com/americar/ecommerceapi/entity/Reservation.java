package com.americar.ecommerceapi.entity;



import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Data
@Entity
@NoArgsConstructor
public class Reservation{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String cancelled;

    @Column
    private String customer;

    @Column()
    @Temporal(TemporalType.DATE)
    private Date dateOrder;

    @Column()
    @Temporal(TemporalType.DATE)
    private Date dateOrderSuplier;

    @Column()
    @Temporal(TemporalType.DATE)
    private Date dateOrigin;

    @Column()
    @Temporal(TemporalType.DATE)
    private Date dateReceipt;

    @Column()
    @Temporal(TemporalType.DATE)
    private Date departureDate;

    @Column()
    @Temporal(TemporalType.DATE)
    private Date endDate;

    @Column()
    @Temporal(TemporalType.DATE)
    private Date endDateCustomerOrder;

    @Column()
    private String nameAplicant;

    @Column()
    private String orderId;

    @Column()
    private String origin;

    @Column()
    private String referenceInput;

    @Column()
    private String referenceOutput;

    @Column()
    private String referenceProviderOrder;

    @OneToMany(mappedBy = "reservation")
    private List<ReservedItem> reservedItems;

    @Column()
    private String route;

    @Column()
    private String sellerName;

    @Column()
    private String shippingId;

    @Column()
    private String startDate;

    @Column()
    private String startDateCustomerOrder;

    @Column()
    private String warehouseId;
}
