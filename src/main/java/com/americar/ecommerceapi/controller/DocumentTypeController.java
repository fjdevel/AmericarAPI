package com.americar.ecommerceapi.controller;

import com.americar.ecommerceapi.dto.DocumentsTypesResponseDto;
import com.americar.ecommerceapi.dto.ErrorDto;
import com.americar.ecommerceapi.entity.DocumentsTypes;
import com.americar.ecommerceapi.service.impl.DocumentTypesService;
import org.intellij.lang.annotations.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/documentTypes")
public class DocumentTypeController {
    @Autowired
    DocumentTypesService documentTypesService;

    @GetMapping
    public ResponseEntity<Object> searchDocumentTypes(@RequestParam String name){
        try{
            DocumentsTypesResponseDto response = new DocumentsTypesResponseDto();
            response.setSellers(documentTypesService.findByName(name));
            return  new ResponseEntity<>(response, HttpStatus.OK);
        }catch (Exception e){
            ErrorDto error = new ErrorDto();
            error.setCode(HttpStatus.BAD_REQUEST.toString());
            error.setMessage(e.getMessage());
            return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
        }
    }

    @Validated
    @GetMapping("/{id}")
    public ResponseEntity<Object> customerDetail(@PathVariable @Pattern(value = "^[0-9a-f]{8}-[0-9a-f]{4}-[1-5][0-9a-f]{3}-[89ab][0-9a-f]{3}-[0-9a-f]{12}$") String id){
        try{
            Optional<DocumentsTypes> response = documentTypesService.findById(id);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch (Exception e){
            ErrorDto error = new ErrorDto();
            error.setCode(HttpStatus.BAD_REQUEST.toString());
            error.setMessage(e.toString());
            return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
        }
    }
}
