package com.americar.ecommerceapi.controller;

import com.americar.ecommerceapi.dto.PartReturnTypesResponseDto;
import com.americar.ecommerceapi.exception.ApiResponse;
import com.americar.ecommerceapi.service.impl.PartReturnTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class PartReturnTypeController {
    @Autowired
    PartReturnTypeService partService;

    @GetMapping("/partsReturnTypes")
    public ResponseEntity<?> getPartReturnTypes() {
        try {
            ApiResponse<PartReturnTypesResponseDto> apiResponse = partService.getPartReturnTypes();
            if (apiResponse.getStatusCode() == HttpStatus.OK.value()) {
                return new ResponseEntity<>(apiResponse.getData(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(apiResponse.getError(), HttpStatus.valueOf(apiResponse.getStatusCode()));
            }
        } catch (IOException e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
