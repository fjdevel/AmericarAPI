package com.americar.ecommerceapi.controller;


import com.americar.ecommerceapi.dto.CustomerCreateDto;
import com.americar.ecommerceapi.dto.CustomersResponse;
import com.americar.ecommerceapi.entity.Customer;
import com.americar.ecommerceapi.service.impl.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;

@RestController
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @GetMapping("/customers")
    public CustomersResponse searchCustomer(@RequestParam(required = false) String name,
                                            @RequestParam(required = false) String id,
                                            @RequestParam(required = false) String documentId,
                                            @RequestParam(required = false) String address,
                                            @RequestParam(required = false) String phoneNumber) throws IOException, NoSuchAlgorithmException, KeyStoreException, KeyManagementException, NoSuchAlgorithmException, KeyStoreException {
        return customerService.getCustomers(name,id,documentId,address,phoneNumber);
    }

    @PostMapping("/customers")
    public ResponseEntity<Customer> createCustomer(@RequestBody CustomerCreateDto data) {
        try {
            Customer createdCustomer = customerService.createCustomer(data);
            return new ResponseEntity<>(createdCustomer, HttpStatus.CREATED);
        } catch (Exception e) {
            // Aquí puedes manejar las excepciones específicas y devolver una respuesta adecuada
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
