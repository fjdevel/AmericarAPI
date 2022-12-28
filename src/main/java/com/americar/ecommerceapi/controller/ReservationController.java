package com.americar.ecommerceapi.controller;

import com.americar.ecommerceapi.dto.ErrorDto;
import com.americar.ecommerceapi.dto.ReservationResponse;
import com.americar.ecommerceapi.service.impl.ReservationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("reservations")
public class ReservationController {

    @Autowired
    ReservationsService service;
    @GetMapping()
    public ResponseEntity<Object> searchReservations(@RequestParam(name = "item") String item,
                                                     @RequestParam(name = "brand") String brand,
                                                     @RequestParam(name = "cancelled") String cancelled,
                                                     @RequestParam(name = "customer") String customer,
                                                     @RequestParam(name = "endDate") Date endDate,
                                                     @RequestParam(name = "origin") String origin,
                                                     @RequestParam(name = "route") String route,
                                                     @RequestParam(name = "salesman") String salesman,
                                                     @RequestParam(name = "shippingId") String shippingId,
                                                     @RequestParam(name = "startDate") Date startDate,
                                                     @RequestParam(name = "status") String status,
                                                     @RequestParam(name = "warehouseId") String warehouseId){
        try {
            ReservationResponse response = service.searchReservations(item, brand, cancelled, customer, endDate, origin, route, salesman, shippingId, startDate, status, warehouseId);
            return new ResponseEntity<>(response, HttpStatus.OK);

        }catch (Exception e){
            ErrorDto error = new ErrorDto();
            error.setCode(HttpStatus.BAD_REQUEST.toString());
            error.setMessage("Unexcepted Error");
            return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
        }
    }
}
