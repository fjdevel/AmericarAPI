package com.americar.ecommerceapi.service;

import com.americar.ecommerceapi.dto.PartReturnCreateResponseDto;
import com.americar.ecommerceapi.dto.PartReturnTypesResponseDto;
import com.americar.ecommerceapi.entity.PartReturnType;
import com.americar.ecommerceapi.exception.ApiResponse;
import com.americar.ecommerceapi.repository.IPartReturnTypeRespository;

import java.io.IOException;
import java.util.List;

public interface IPartReturnTypeService {
    ApiResponse<PartReturnTypesResponseDto> getPartReturnTypes() throws IOException;
}
