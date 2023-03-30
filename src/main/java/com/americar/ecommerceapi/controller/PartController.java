package com.americar.ecommerceapi.controller;


import com.americar.ecommerceapi.dto.PartsResponseDto;
import com.americar.ecommerceapi.exception.ApiResponse;
import com.americar.ecommerceapi.service.impl.PartReturnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Map;


@RestController
public class PartController {

    @Autowired
    PartReturnService partService;
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

}
