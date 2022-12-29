package com.americar.ecommerceapi.service;

import com.americar.ecommerceapi.dto.ReservationResponse;
import org.springframework.data.repository.query.Param;

import java.util.Date;

public interface IReservationsService {
    public ReservationResponse searchReservations(String item,String brand, String cancelled,String customer, Date endDate,
                                                 String origin, String route, String salesman, String shippingId,
                                                  String startDate,  String status, String warehouseId);
}
