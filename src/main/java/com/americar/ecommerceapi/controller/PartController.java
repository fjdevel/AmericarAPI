package com.americar.ecommerceapi.controller;


import com.americar.ecommerceapi.dto.ErrorDto;
import com.americar.ecommerceapi.dto.PartReturnCreateDto;
import com.americar.ecommerceapi.dto.PartReturnCreateResponseDto;
import com.americar.ecommerceapi.dto.PartsResponseDto;
import com.americar.ecommerceapi.entity.Part;
import com.americar.ecommerceapi.entity.Warehouse;
import com.americar.ecommerceapi.exception.ApiResponse;
import com.americar.ecommerceapi.service.impl.PartReturnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Map;


@RestController
public class PartController {

    @Autowired
    PartReturnService partService;

    @PostMapping("/partsReturn")
    public ResponseEntity<?> createPartReturn(@RequestBody PartReturnCreateDto partReturnDto) {
        try {
            ApiResponse<PartReturnCreateResponseDto> apiResponse = partService.createPartReturn(partReturnDto);

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
    @GetMapping("/parts")
    public ResponseEntity<?> searchParts(@RequestParam Map<String, String> queryParams) throws IOException {
        try {
            ApiResponse<PartsResponseDto> apiResponse = partService.searchParts(queryParams);
            if (apiResponse.getStatusCode() == HttpStatus.OK.value()) {
                return new ResponseEntity<>(apiResponse.getData(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(apiResponse.getError(), HttpStatus.valueOf(apiResponse.getStatusCode()));
            }
        } catch (IOException e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/parts/{id}")
    public ResponseEntity<?> getPartById(@PathVariable String id) {
        try {
            ApiResponse<Part> apiResponse = partService.getPartById(id);

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

    @GetMapping("/parts2")
    public ResponseEntity<?> searchParts(
            @RequestParam(required = false) String id,
            @RequestParam(required = false) String description,
            @RequestParam(required = false) String family,
            @RequestParam(required = false) String entryDate,
            @RequestParam(required = false) String brand
    ) {
        try {
            ApiResponse<PartsResponseDto> apiResponse = partService.searchParts(id, description, family, entryDate, brand);

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
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/partsoem")
    public ResponseEntity<?> searchOemParts(
            @RequestParam(required = false) String id,
            @RequestParam(required = false) String description,
            @RequestParam(required = false) String family,
            @RequestParam(required = false) String entryDate,
            @RequestParam(required = false) String brand
    ) {
        try {
            ApiResponse<PartsResponseDto> apiResponse = partService.searchOemParts(id, description, family, entryDate, brand);

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
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/warehouses/{id}")
    public ResponseEntity<?> getWarehouseById(@PathVariable String id) {
        try {
            ApiResponse<Warehouse> apiResponse =partService.getWarehouseById(id);

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
