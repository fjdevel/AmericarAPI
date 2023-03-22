package com.americar.ecommerceapi.controller;


import com.americar.ecommerceapi.dto.CustomerCreateDto;
import com.americar.ecommerceapi.dto.CustomersResponse;
import com.americar.ecommerceapi.dto.ErrorDto;
import com.americar.ecommerceapi.entity.Customer;
import com.americar.ecommerceapi.security.AuthenticationService;
import com.americar.ecommerceapi.service.impl.CustomerService;
import org.intellij.lang.annotations.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @Autowired
    private AuthenticationService authenticationService;


    @GetMapping("/searchCustomers")
    public ResponseEntity<Object> searchCustomer(HttpServletRequest request, @RequestParam(required = false) String name,
                                                 @RequestParam(required = false) String id,
                                                 @RequestParam(required = false) String documentId,
                                                 @RequestParam(required = false) String address,
                                                 @RequestParam(required = false) String phoneNumber) {
        try {
            String token = authenticationService.getAccessToken(request);

            CustomersResponse response = customerService.getCustomers(token,name, id, documentId, address, phoneNumber);

            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            ErrorDto error = new ErrorDto();
            error.setCode(HttpStatus.BAD_REQUEST.toString());
            error.setMessage(e.toString());
            return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
        }
    }


}
