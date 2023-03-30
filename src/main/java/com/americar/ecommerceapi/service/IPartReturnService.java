package com.americar.ecommerceapi.service;


import com.americar.ecommerceapi.dto.PartsResponseDto;
import com.americar.ecommerceapi.dto.VehiclesResponseDto;
import com.americar.ecommerceapi.entity.Vehicle;
import com.americar.ecommerceapi.exception.ApiResponse;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Map;

public interface IPartReturnService {
    ApiResponse<PartsResponseDto> searchParts(Map<String, String> queryParams) throws IOException, URISyntaxException;

    ApiResponse<VehiclesResponseDto> searchVehicles(Map<String, String> queryParams) throws IOException;

    ApiResponse<Vehicle> getVehicleById(String id) throws IOException;

}
