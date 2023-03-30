package com.americar.ecommerceapi.service;


import com.americar.ecommerceapi.dto.PartsResponseDto;
import com.americar.ecommerceapi.dto.VehiclesResponseDto;
import com.americar.ecommerceapi.entity.Part;
import com.americar.ecommerceapi.entity.Vehicle;
import com.americar.ecommerceapi.exception.ApiResponse;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Map;

public interface IPartReturnService {
    ApiResponse<PartsResponseDto> searchParts(Map<String, String> queryParams) throws IOException, URISyntaxException;

    ApiResponse<VehiclesResponseDto> searchVehicles(Map<String, String> queryParams) throws IOException;

    ApiResponse<Vehicle> getVehicleById(String id) throws IOException;

    ApiResponse<Part> getPartById(String id) throws IOException;
    ApiResponse<PartsResponseDto> searchParts(String id, String description, String family, String entryDate, String brand) throws IOException, URISyntaxException;

    ApiResponse<PartsResponseDto> searchOemParts(String id, String description, String family, String entryDate, String brand) throws IOException, URISyntaxException;


}
