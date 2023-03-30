package com.americar.ecommerceapi.service;

import com.americar.ecommerceapi.entity.ImagePart;
import com.americar.ecommerceapi.exception.ApiResponse;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface IImagePartService {
    ApiResponse<List<ImagePart>> getImagePartsById(String id) throws IOException;

}
