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

import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping("reservations")
public class ReservationController {

    @Autowired
    ReservationsService service;
    @GetMapping()
    public ResponseEntity<Object> searchReservations(@RequestParam(name = "item",required = false) String item,
                                                     @RequestParam(name = "brand",required = false) String brand,
                                                     @RequestParam(name = "cancelled",required = false) String cancelled,
                                                     @RequestParam(name = "customer",required = false) String customer,
                                                     @RequestParam(name = "endDate",required = false, defaultValue = "") String endDate,
                                                     @RequestParam(name = "origin",required = false) String origin,
                                                     @RequestParam(name = "route",required = false) String route,
                                                     @RequestParam(name = "salesman",required = false) String salesman,
                                                     @RequestParam(name = "shippingId",required = false) String shippingId,
                                                     @RequestParam(name = "startDate",required = false) String startDate,
                                                     @RequestParam(name = "status",required = false) String status,
                                                     @RequestParam(name = "warehouseId",required = false) String warehouseId){
        try {
            Date endDated;
            if(endDate.equals(""))
                 endDated= new Date();
            else
               endDated= new SimpleDateFormat("dd/MM/yyyy").parse(endDate);
            ReservationResponse response = service.searchReservations(item, brand, cancelled, customer, endDated, origin, route, salesman, shippingId, startDate, status, warehouseId);
            return new ResponseEntity<>(response, HttpStatus.OK);

        }catch (Exception e){
            ErrorDto error = new ErrorDto();
            error.setCode(HttpStatus.BAD_REQUEST.toString());
            error.setMessage(e.toString());
            return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
        }
    }
}
