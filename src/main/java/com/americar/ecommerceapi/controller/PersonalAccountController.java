package com.americar.ecommerceapi.controller;

import com.americar.ecommerceapi.dto.ErrorDto;
import com.americar.ecommerceapi.dto.PersonalAccountsCategoriesResponseDto;
import com.americar.ecommerceapi.entity.PersonalAccountsCategories;
import com.americar.ecommerceapi.service.impl.PersonalAccountCategoriesService;
import org.intellij.lang.annotations.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
@RequestMapping("/personalAccountsCategories")
public class PersonalAccountController {

    @Autowired
    PersonalAccountCategoriesService service;
    @GetMapping
    public ResponseEntity<Object> searchPersonalAccountCategories(@RequestParam(name = "description",required = false) String description,
                                                                  @RequestParam(name = "type",required = false) String type){
        try {
            PersonalAccountsCategoriesResponseDto response = service.searchPersonalAccountsCategories(description,type);
            return new ResponseEntity<>(response, HttpStatus.OK);

        }catch (Exception e){
            ErrorDto error = new ErrorDto();
            error.setCode(HttpStatus.BAD_REQUEST.toString());
            error.setMessage("Unexcepted Error");
            return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
        }
    }

    @Validated
    @GetMapping("/{id}")
    public ResponseEntity<Object> personalAccountsCategoriesById(@PathVariable @Pattern(value = "^[0-9a-f]{8}-[0-9a-f]{4}-[1-5][0-9a-f]{3}-[89ab][0-9a-f]{3}-[0-9a-f]{12}$") String id){
        try {
            Optional<PersonalAccountsCategories> response = service.searchById(id);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch (Exception e){
            ErrorDto error = new ErrorDto();
            error.setCode(HttpStatus.BAD_REQUEST.toString());
            error.setMessage("Unexcepted Error");
            return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
        }
    }
}
