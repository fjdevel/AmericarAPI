package com.americar.ecommerceapi.controller;

import com.americar.ecommerceapi.dto.ErrorDto;
import com.americar.ecommerceapi.dto.PartsOEMResponse;
import com.americar.ecommerceapi.service.impl.PartOEMService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;

@RestController
public class PartOEMController {
    @Autowired
    PartOEMService partOEMService;

    @GetMapping("/partsoem")
    public ResponseEntity<Object> OEMPartSearch(@RequestParam(name = "brand",required = false) String brand,
                                                @RequestParam(name = "description",required = false) String description,
                                                @RequestParam(name = "entryDate",required = false) String entryDate,
                                                @RequestParam(name = "family",required = false) String family,
                                                @RequestParam(name = "id",required = false) String id){
        try{
            PartsOEMResponse response = partOEMService.searchPartOEM(brand,description, Date.valueOf(entryDate),family,id);
            return  new ResponseEntity<>(response, HttpStatus.OK);
        }catch (Exception e){
            ErrorDto error = new ErrorDto();
            error.setCode(HttpStatus.BAD_REQUEST.toString());
            error.setMessage("Unexpected Error");
            return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
        }
    }
}
