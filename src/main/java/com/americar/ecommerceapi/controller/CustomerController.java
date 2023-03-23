package com.americar.ecommerceapi.controller;


import com.americar.ecommerceapi.dto.CustomersResponse;
import com.americar.ecommerceapi.service.impl.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @GetMapping("/searchCustomers")
    public CustomersResponse searchCustomer(@RequestParam(required = false) String name,
                                            @RequestParam(required = false) String id,
                                            @RequestParam(required = false) String documentId,
                                            @RequestParam(required = false) String address,
                                            @RequestParam(required = false) String phoneNumber) throws IOException, NoSuchAlgorithmException, KeyStoreException, KeyManagementException {
        return customerService.getCustomers(name,id,documentId,address,phoneNumber);
    }


}
