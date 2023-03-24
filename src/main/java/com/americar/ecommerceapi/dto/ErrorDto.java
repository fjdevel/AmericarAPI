package com.americar.ecommerceapi.dto;

import javax.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
public class ErrorDto {
    private String code;

    private String message;
}
