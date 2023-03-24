package com.americar.ecommerceapi.entity;


import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
public class WorkshopId {
    private String id;

    private String workshopId;

    Vehicle vehicle;
}
