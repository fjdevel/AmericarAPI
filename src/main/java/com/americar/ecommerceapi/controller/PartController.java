package com.americar.ecommerceapi.controller;

import com.americar.ecommerceapi.dto.ErrorDto;
import com.americar.ecommerceapi.dto.PartReturnCreateDto;
import com.americar.ecommerceapi.dto.PartReturnCreateResponseDto;
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

@RestController
public class PartController {
    @Autowired
    PartReturnService partService;

    @PostMapping("/partsReturn")
    public ResponseEntity<Object> createPartReturn(@RequestBody @Valid PartReturnCreateDto partReturnCreateDto,
                                                   BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            // Si hay errores de validacion, se devuelve una respuesta con el código de error y la lista de errores
            return ResponseEntity.badRequest().body(bindingResult.getAllErrors());
        }

        try {
            PartReturnCreateResponseDto partReturnCreateResponseDto = new PartReturnCreateResponseDto();
            partReturnCreateResponseDto = partService.createPartReturn(partReturnCreateDto);
            return  new ResponseEntity<>(partReturnCreateResponseDto, HttpStatus.OK);
        }catch (Exception e){
            ErrorDto error = new ErrorDto();
            error.setCode(HttpStatus.BAD_REQUEST.toString());
            error.setMessage("Unexpected Error");
            return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
        }
    }
}
