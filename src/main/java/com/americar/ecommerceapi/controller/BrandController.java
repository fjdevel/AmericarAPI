package com.americar.ecommerceapi.controller;

import com.americar.ecommerceapi.dto.BrandsResponseDto;
import com.americar.ecommerceapi.dto.ErrorDto;
import com.americar.ecommerceapi.entity.Brand;
import com.americar.ecommerceapi.service.impl.BrandService;
import org.intellij.lang.annotations.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

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
           error.setMessage("Unexpected error");
           return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
       }
    }
    @Validated
    @GetMapping("/{id}")
    public ResponseEntity<Object> brandDetail(@PathVariable @Pattern(value = "^[0-9a-f]{8}-[0-9a-f]{4}-[1-5][0-9a-f]{3}-[89ab][0-9a-f]{3}-[0-9a-f]{12}$") String id){
        try{
           Optional<Brand> brandResponse = brandService.findById(UUID.fromString(id));
            return new ResponseEntity<>(brandResponse, HttpStatus.OK);
        }catch (Exception e){
            ErrorDto error = new ErrorDto();
            error.setCode(HttpStatus.BAD_REQUEST.toString());
            error.setMessage("Unexpected error");
            return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
        }
    }

}
