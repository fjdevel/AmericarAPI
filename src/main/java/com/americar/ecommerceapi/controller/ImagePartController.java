package com.americar.ecommerceapi.controller;

import com.americar.ecommerceapi.dto.ErrorDto;
import com.americar.ecommerceapi.dto.ImagePartResponse;
import com.americar.ecommerceapi.entity.ImagePart;
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

import java.util.Optional;

@RestController
@RequestMapping("/imagePart")
public class ImagePartController {
    @Autowired
    ImagePartService imagePartService;

    @Validated
    @GetMapping()
    public ResponseEntity<Object> ImagePartSearch(@RequestParam@Pattern(value = "^[0-9a-f]{8}-[0-9a-f]{4}-[1-5][0-9a-f]{3}-[89ab][0-9a-f]{3}-[0-9a-f]{12}$") String id){
        try{
            ImagePartResponse response = new ImagePartResponse();
            Optional<ImagePart> image = imagePartService.findById(id);
           response.getImagePart().add(image);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch (Exception e){
            ErrorDto error = new ErrorDto();
            error.setCode(HttpStatus.BAD_REQUEST.toString());
            error.setMessage(e.toString());
            return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
        }
    }
}
