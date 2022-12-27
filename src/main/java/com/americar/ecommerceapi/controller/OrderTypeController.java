package com.americar.ecommerceapi.controller;

import com.americar.ecommerceapi.dto.ErrorDto;
import com.americar.ecommerceapi.dto.OrderTypesResponseDto;
import com.americar.ecommerceapi.entity.OrderType;
import com.americar.ecommerceapi.service.impl.OrderTypeService;
import org.intellij.lang.annotations.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/orderTypes")
public class OrderTypeController {
    @Autowired
    OrderTypeService orderTypeService;

    @GetMapping()
    public ResponseEntity<Object> findAll(@RequestParam(defaultValue = "0") int page,
                                          @RequestParam(defaultValue = "10") int size){
        try {
            OrderTypesResponseDto response = new OrderTypesResponseDto();
            response.setOrderTypes((List<OrderType>) orderTypeService.findAll(page,size));
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch (Exception e){
            ErrorDto error = new ErrorDto();
            error.setCode(HttpStatus.BAD_REQUEST.toString());
            error.setMessage(e.toString());
            return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
        }
    }

    @Validated
    @GetMapping("/{id}")
    public ResponseEntity<Object> brandDetail(@PathVariable @Pattern(value = "^[0-9a-f]{8}-[0-9a-f]{4}-[1-5][0-9a-f]{3}-[89ab][0-9a-f]{3}-[0-9a-f]{12}$") String id){
        try{
            Optional<OrderType> response = orderTypeService.findById(id);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch (Exception e){
            ErrorDto error = new ErrorDto();
            error.setCode(HttpStatus.BAD_REQUEST.toString());
            error.setMessage("Unexpected error");
            return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
        }
    }


}
