package com.americar.ecommerceapi.controller;

import com.americar.ecommerceapi.dto.CodeShippingResponseDto;
import com.americar.ecommerceapi.dto.ErrorDto;
import com.americar.ecommerceapi.service.impl.CodeShippingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/codeShipping")
public class CodeShippingController {
    @Autowired
    CodeShippingService codeShippingService;

    @GetMapping()
    public ResponseEntity<Object> searchByAccount(@RequestParam("account") String account){
        try{
            CodeShippingResponseDto response = new CodeShippingResponseDto();
            response.setCodeShipping(codeShippingService.findByAccount(account));
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch (Exception e){
            ErrorDto error = new ErrorDto();
            error.setCode(HttpStatus.BAD_REQUEST.toString());
            error.setMessage("Unexpected error");
            return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
        }
    }
}
