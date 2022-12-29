package com.americar.ecommerceapi.service.impl;

import com.americar.ecommerceapi.dto.ReservationResponse;
import com.americar.ecommerceapi.repository.IReservationsRepository;
import com.americar.ecommerceapi.service.IReservationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ReservationsService implements IReservationsService {

    @Autowired
    IReservationsRepository repository;
    @Override
    public ReservationResponse searchReservations(String itemId,String brand, String cancelled, String customer, Date endDate, String origin, String route, String salesman, String shippingId, String startDate, String status, String warehouseId) {
        ReservationResponse response = new ReservationResponse();
        response.setReservations(repository.findByAttributes(itemId,brand, cancelled, customer, endDate, origin, route, salesman, shippingId, startDate, status, warehouseId));
        return response;
    }
}
