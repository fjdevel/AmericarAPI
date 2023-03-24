package com.americar.ecommerceapi.exception;

import com.americar.ecommerceapi.dto.ErrorDto;
import lombok.Data;

@Data
public class ApiResponse<T> {
    private int statusCode;
    private T data;
    private ErrorDto error;

    // Constructores, getters y setters
}