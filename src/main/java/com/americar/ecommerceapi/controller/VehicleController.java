package com.americar.ecommerceapi.controller;

import com.americar.ecommerceapi.dto.ErrorDto;
import com.americar.ecommerceapi.dto.VehiclesResponseDto;
import com.americar.ecommerceapi.entity.Vehicle;
import com.americar.ecommerceapi.exception.ApiResponse;
import com.americar.ecommerceapi.service.impl.PartReturnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Map;

@RestController
public class VehicleController {
    @Autowired
    PartReturnService partService;
    @GetMapping("/vehicles")
    public ResponseEntity<?> searchVehicles(@RequestParam Map<String, String> queryParams) throws IOException {
        try {
            ApiResponse<VehiclesResponseDto> apiResponse = partService.searchVehicles(queryParams);
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

    @GetMapping("/vehicles/{id}")
    public ResponseEntity<?> getVehicleById(@PathVariable String id) {
        try {
            ApiResponse<Vehicle> apiResponse = partService.getVehicleById(id);

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
