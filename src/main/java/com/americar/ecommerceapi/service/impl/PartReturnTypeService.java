package com.americar.ecommerceapi.service.impl;

import com.americar.ecommerceapi.dto.PartsReturnTypesResponse;
import com.americar.ecommerceapi.repository.IPartReturnRepository;
import com.americar.ecommerceapi.repository.IPartReturnTypeRespository;
import com.americar.ecommerceapi.service.IPartReturnTypeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PartReturnTypeService implements IPartReturnTypeService {
    @Autowired
    IPartReturnTypeRespository partReturnRepository;

    private final ModelMapper modelMapper;

    @Autowired
    public PartReturnTypeService(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }
    @Override
    public PartsReturnTypesResponse obtenerTodos(){
        PartsReturnTypesResponse response = new PartsReturnTypesResponse();
      response.setPartReturnTypes(partReturnRepository.findAll());
        return response;
    }
}
