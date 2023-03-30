package com.americar.ecommerceapi.controller;

import com.americar.ecommerceapi.dto.BrandsResponseDto;
import com.americar.ecommerceapi.dto.ErrorDto;
import com.americar.ecommerceapi.entity.Brand;
import com.americar.ecommerceapi.exception.ApiResponse;
import com.americar.ecommerceapi.service.impl.BrandService;
import org.intellij.lang.annotations.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Optional;


@RestController
public class BrandController {
    @Autowired
    BrandService brandService;
    @GetMapping("/brands")
    public ResponseEntity<?> searchBrands(@RequestParam String description) {
        try {
            ApiResponse<List<BrandsResponseDto>> apiResponse = brandService.searchBrands(description);

            if (apiResponse.getStatusCode() == HttpStatus.OK.value()) {
                return new ResponseEntity<>(apiResponse.getData(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(apiResponse.getError(), HttpStatus.valueOf(apiResponse.getStatusCode()));
            }
        } catch (IOException e) {
            ErrorDto errorDto = new ErrorDto();
            errorDto.setCode("500");
            errorDto.setMessage("Internal Server Error");
            return new ResponseEntity<>(errorDto, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/brands/{id}")
    public ResponseEntity<?> getBrandById(@PathVariable String id) {
        try {
            ApiResponse<BrandsResponseDto> apiResponse = brandService.getBrandById(id);

            if (apiResponse.getStatusCode() == HttpStatus.OK.value()) {
                return new ResponseEntity<>(apiResponse.getData(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(apiResponse.getError(), HttpStatus.valueOf(apiResponse.getStatusCode()));
            }
        } catch (IOException e) {
            ErrorDto errorDto = new ErrorDto();
            errorDto.setCode("500");
            errorDto.setMessage("Internal Server Error");
            return new ResponseEntity<>(errorDto, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
