package com.americar.ecommerceapi.controller;

import com.americar.ecommerceapi.dto.ErrorDto;
import com.americar.ecommerceapi.dto.PartReturnCreateDto;
import com.americar.ecommerceapi.dto.PartReturnCreateResponseDto;
import com.americar.ecommerceapi.exception.ApiResponse;
import com.americar.ecommerceapi.service.impl.PartReturnService;
import com.americar.ecommerceapi.service.impl.SparePartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.io.IOException;

@RestController
public class PartController {
    @Autowired
    PartReturnService partService;

    @PostMapping("/partsReturn")
    public ResponseEntity<?> createPartReturn(@RequestBody PartReturnCreateDto partReturnCreateDto) throws IOException, IOException {
        try {
            ApiResponse<PartReturnCreateResponseDto> apiResponse =partService.createPartReturn(partReturnCreateDto);
            if (apiResponse.getStatusCode() == HttpStatus.OK.value()) {
                return new ResponseEntity<>(apiResponse.getData(), HttpStatus.OK);
            } else {
                // Puedes personalizar el manejo de errores aquí, por ejemplo, devolver un ResponseEntity con el objeto ErrorDto y un código de estado personalizado.
                return new ResponseEntity<>(apiResponse.getError(), HttpStatus.valueOf(apiResponse.getStatusCode()));            }
        } catch (IOException e) {
            // Manejar la excepción IOException si es necesario
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
