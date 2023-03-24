package com.americar.ecommerceapi.entity;



import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;


@Data
@NoArgsConstructor
public class Reservation{
    private Integer id;

    private String cancelled;

    private String customer;

    private Date dateOrder;

    private Date dateOrderSuplier;

    private Date dateOrigin;

    private Date dateReceipt;

    private Date departureDate;

    private Date endDate;
    private Date endDateCustomerOrder;

    private String nameAplicant;

    private String orderId;


    private String origin;


    private String referenceInput;


    private String referenceOutput;


    private String referenceProviderOrder;

    private List<ReservedItem> reservedItems = null;


    private String route;


    private String sellerName;


    private String shippingId;


    private String startDate;


    private String startDateCustomerOrder;


    private String warehouseId;
}
