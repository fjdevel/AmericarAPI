package com.americar.ecommerceapi.controller;

import com.americar.ecommerceapi.dto.ErrorDto;
import com.americar.ecommerceapi.dto.PartsResponseDto;
import com.americar.ecommerceapi.entity.Part;
import com.americar.ecommerceapi.service.impl.SparePartService;
import org.intellij.lang.annotations.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/parts")
public class SparePartController {
    @Autowired
    SparePartService partService;

    @GetMapping()
    public ResponseEntity<Object> searchPart(@RequestParam(name = "brand",required = false) String brand,
                                             @RequestParam(name = "customerId",required = false) String customerId,
                                             @RequestParam(name = "family",required = false) String family,
                                             @RequestParam(name = "id",required = false) String id,
                                             @RequestParam(name = "quantity",required = false) Integer quantity,
                                             @RequestParam(name = "shippingId",required = false) String shippingId,
                                             @RequestParam(name = "warehouseId",required = false) List<String> warehouseId){
        try{
            PartsResponseDto responseDto = partService.searchPart(brand, customerId, family, id, quantity, shippingId, warehouseId);
            return new ResponseEntity<>(responseDto,HttpStatus.OK);
        }catch (Exception e){
            ErrorDto error = new ErrorDto();
            error.setCode(HttpStatus.BAD_REQUEST.toString());
            error.setMessage("Unexcepted Error");
            return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
        }

    }

    @Validated
    @GetMapping("/{id}")
    public ResponseEntity<Object> searchPart(@PathVariable @Pattern(value = "^[0-9a-f]{8}-[0-9a-f]{4}-[1-5][0-9a-f]{3}-[89ab][0-9a-f]{3}-[0-9a-f]{12}$") String id){
        try{
            Optional<Part> response = partService.searchById(id);
            return new ResponseEntity<>(response,HttpStatus.OK);
        }catch (Exception e){
            ErrorDto error = new ErrorDto();
            error.setCode(HttpStatus.BAD_REQUEST.toString());
            error.setMessage("Unexcepted Error");
            return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
        }
    }
}
