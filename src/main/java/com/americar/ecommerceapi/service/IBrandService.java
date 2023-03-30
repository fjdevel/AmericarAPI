package com.americar.ecommerceapi.service;

import com.americar.ecommerceapi.dto.BrandsResponseDto;
import com.americar.ecommerceapi.entity.Brand;
import com.americar.ecommerceapi.exception.ApiResponse;

import java.io.IOException;
import java.util.List;
import java.util.Optional;


public interface IBrandService {
    ApiResponse<List<BrandsResponseDto>> searchBrands(String description) throws IOException;

}