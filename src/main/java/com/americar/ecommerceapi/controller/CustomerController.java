package com.americar.ecommerceapi.controller;


import com.americar.ecommerceapi.dto.CustomerCreateDto;
import com.americar.ecommerceapi.dto.CustomersResponse;
import com.americar.ecommerceapi.dto.ErrorDto;
import com.americar.ecommerceapi.entity.Customer;
import com.americar.ecommerceapi.service.impl.CustomerService;
import org.intellij.lang.annotations.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @PostMapping
    public ResponseEntity<Object> createCustomer(@RequestBody @Valid CustomerCreateDto customerCreateDto,
                                                 BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            // Si hay errores de validacion, se devuelve una respuesta con el código de error y la lista de errores
            return ResponseEntity.badRequest().body(bindingResult.getAllErrors());
        }
        try{
            Customer customer = customerService.createCustomer(customerCreateDto);
            return  new ResponseEntity<>(customer, HttpStatus.OK);
        }catch (Exception e){
            ErrorDto error = new ErrorDto();
            error.setCode(HttpStatus.BAD_REQUEST.toString());
            error.setMessage("Unexpected Error");
            return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping()
    public ResponseEntity<Object> searchCustomer(@RequestParam(name = "id",required = false) String id,
                                                 @RequestParam(name = "address",required = false) String address,
                                                 @RequestParam(name = "documentID",required = false) String documentId,
                                                 @RequestParam(name = "name",required = false) String name,
                                                 @RequestParam(name = "phoneNumber",required = false) List<String> phoneNumbers){

        try {
            CustomersResponse response = new CustomersResponse();
            response.setCustomers(customerService.searchCustomer(address,documentId, id,name,phoneNumbers));
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch (Exception e){
            ErrorDto error = new ErrorDto();
            error.setCode(HttpStatus.BAD_REQUEST.toString());
            error.setMessage("Unexcepted Error");
            return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
        }
    }

    @Validated
    @GetMapping("/{id}")
    public ResponseEntity<Object> customerDetail(@PathVariable @Pattern(value = "^[0-9a-f]{8}-[0-9a-f]{4}-[1-5][0-9a-f]{3}-[89ab][0-9a-f]{3}-[0-9a-f]{12}$") String id){
        try{
            Optional<Customer> customer= customerService.findById(id);
            return new ResponseEntity<>(customer, HttpStatus.OK);
        }catch (Exception e){
            ErrorDto error = new ErrorDto();
            error.setCode(HttpStatus.BAD_REQUEST.toString());
            error.setMessage("Unexcepted Error");
            return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
        }
    }
}
