package com.americar.ecommerceapi.service.impl;

import com.americar.ecommerceapi.dto.PartReturnCreateDto;
import com.americar.ecommerceapi.dto.PartReturnCreateResponseDto;
import com.americar.ecommerceapi.entity.PartReturns;
import com.americar.ecommerceapi.repository.IPartReturnRepository;
import com.americar.ecommerceapi.service.IPartReturnService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PartReturnService implements IPartReturnService {

    @Autowired
    IPartReturnRepository partReturnRepository;

    private final ModelMapper modelMapper;

    @Autowired
    public PartReturnService(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public PartReturnCreateResponseDto createPartReturn(PartReturnCreateDto partReturnCreateDto) {
        PartReturns part = new PartReturns();
        String uuid = UUID.randomUUID().toString();
        modelMapper.map(partReturnCreateDto,part);
        part.setId(uuid);
        PartReturnCreateResponseDto response = new PartReturnCreateResponseDto();
        partReturnRepository.save(part);
        modelMapper.map(part,response);
        return response;

    }
}
