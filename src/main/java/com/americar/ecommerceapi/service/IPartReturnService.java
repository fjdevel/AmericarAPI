package com.americar.ecommerceapi.service;

import com.americar.ecommerceapi.dto.PartReturnCreateDto;
import com.americar.ecommerceapi.dto.PartReturnCreateResponseDto;

public interface IPartReturnService {
    public PartReturnCreateResponseDto createPartReturn(PartReturnCreateDto partReturnCreateDto);

}
