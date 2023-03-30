package com.americar.ecommerceapi.controller;

import com.americar.ecommerceapi.dto.ErrorDto;
import com.americar.ecommerceapi.dto.ImagePartResponse;
import com.americar.ecommerceapi.entity.ImagePart;
import com.americar.ecommerceapi.exception.ApiResponse;
import com.americar.ecommerceapi.service.impl.ImagePartService;
import org.intellij.lang.annotations.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
public class ImagePartController {
    @Autowired
    ImagePartService imagePartService;
    @GetMapping("/imagesParts")
    public ResponseEntity<?> getImagePartsById(@RequestParam String partId) {
        try {
            ApiResponse<List<ImagePart>> apiResponse = imagePartService.getImagePartsById(partId);

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
