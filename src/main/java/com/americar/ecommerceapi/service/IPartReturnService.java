package com.americar.ecommerceapi.service;

import com.americar.ecommerceapi.dto.PartReturnCreateDto;
import com.americar.ecommerceapi.dto.PartReturnCreateResponseDto;
import com.americar.ecommerceapi.exception.ApiResponse;

import java.io.IOException;

public interface IPartReturnService {
    public ApiResponse<PartReturnCreateResponseDto> createPartReturn(PartReturnCreateDto partReturnCreateDto) throws IOException;


}
