package com.americar.ecommerceapi.controller;

import com.americar.ecommerceapi.dto.ErrorDto;
import com.americar.ecommerceapi.dto.OrderCreateDto;
import com.americar.ecommerceapi.entity.Order;
import com.americar.ecommerceapi.service.impl.OrderService;
import org.intellij.lang.annotations.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping
    public ResponseEntity<Object> createOrder(@RequestBody @Valid OrderCreateDto orderCreateDto, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            // Si hay errores de validacion, se devuelve una respuesta con el código de error y la lista de errores
            return ResponseEntity.badRequest().body(bindingResult.getAllErrors());
        }
        try{
            Order response = orderService.createOrder(orderCreateDto);
            return  new ResponseEntity<>(response, HttpStatus.OK);
        }catch (Exception e){
            ErrorDto error = new ErrorDto();
            error.setCode(HttpStatus.BAD_REQUEST.toString());
            error.setMessage(e.getMessage());
            return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
        }
    }

    @Validated
    @GetMapping("/{id}")
    public ResponseEntity<Object> orderDetail(@PathVariable @Pattern(value = "^[0-9a-f]{8}-[0-9a-f]{4}-[1-5][0-9a-f]{3}-[89ab][0-9a-f]{3}-[0-9a-f]{12}$") String id){
        try {
            Optional<Order> order = orderService.findById(id);
            return new ResponseEntity<>(order,HttpStatus.OK);
        }catch (Exception e){
        ErrorDto error = new ErrorDto();
        error.setCode(HttpStatus.BAD_REQUEST.toString());
        error.setMessage(" Unexpected error");
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
    }
}
