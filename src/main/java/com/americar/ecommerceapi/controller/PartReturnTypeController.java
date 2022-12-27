package com.americar.ecommerceapi.controller;

import com.americar.ecommerceapi.dto.ErrorDto;
import com.americar.ecommerceapi.dto.PartsReturnTypesResponse;
import com.americar.ecommerceapi.service.impl.PartReturnTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/partsReturnTypes")
public class PartReturnTypeController {
    @Autowired
    PartReturnTypeService partReturnTypeService;


    @GetMapping()
    public ResponseEntity<Object> getPartReturnTypes(){
        try{
            PartsReturnTypesResponse response = partReturnTypeService.obtenerTodos();
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch (Exception e){
            ErrorDto error = new ErrorDto();
            error.setCode(HttpStatus.BAD_REQUEST.toString());
            error.setMessage("Unexpected error");
            return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
        }
    }

}
