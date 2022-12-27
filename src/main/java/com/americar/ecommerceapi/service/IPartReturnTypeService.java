package com.americar.ecommerceapi.service;

import com.americar.ecommerceapi.dto.PartsReturnTypesResponse;
import com.americar.ecommerceapi.entity.PartReturnType;
import com.americar.ecommerceapi.repository.IPartReturnTypeRespository;

import java.util.List;

public interface IPartReturnTypeService {
    public PartsReturnTypesResponse  obtenerTodos();
}
