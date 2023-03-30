package com.americar.ecommerceapi.service;


import com.americar.ecommerceapi.dto.PartsResponseDto;
import com.americar.ecommerceapi.exception.ApiResponse;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Map;

public interface IPartReturnService {
    public ApiResponse<PartsResponseDto> searchParts(Map<String, String> queryParams) throws IOException, URISyntaxException;


}
