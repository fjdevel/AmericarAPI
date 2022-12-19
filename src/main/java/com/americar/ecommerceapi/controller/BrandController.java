package com.americar.ecommerceapi.controller;

import com.americar.ecommerceapi.dto.BrandsResponseDto;
import com.americar.ecommerceapi.dto.ErrorDto;
import com.americar.ecommerceapi.service.impl.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/brands")
public class BrandController {
    @Autowired
    private BrandService brandService;

    @GetMapping()
    public ResponseEntity<Object> searchByDescription(@RequestParam("description") String description){
       try{
           BrandsResponseDto response = new BrandsResponseDto();
           response.setBrands(brandService.findByDescription(description));
           return new ResponseEntity<>(response, HttpStatus.OK);
       }catch (Exception e){
           ErrorDto error = new ErrorDto();
           error.setCode(HttpStatus.BAD_REQUEST.toString());
           error.setMessage(e.getMessage());
           return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
       }
    }
}
