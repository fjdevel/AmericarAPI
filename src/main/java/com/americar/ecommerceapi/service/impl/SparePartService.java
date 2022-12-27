package com.americar.ecommerceapi.service.impl;

import com.americar.ecommerceapi.dto.PartReturnCreateDto;
import com.americar.ecommerceapi.dto.PartReturnCreateResponseDto;
import com.americar.ecommerceapi.dto.PartsResponseDto;
import com.americar.ecommerceapi.entity.Part;
import com.americar.ecommerceapi.entity.PartReturns;
import com.americar.ecommerceapi.repository.ISparePartRepository;
import com.americar.ecommerceapi.service.ISparePartService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class SparePartService implements ISparePartService {

    @Autowired
    ISparePartRepository partRepository;

    private final ModelMapper modelMapper;

    @Autowired
    public SparePartService(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public PartsResponseDto searchPart(String brand, String customerId, String family, String Id, Integer quantity, String shippingId, String warehouseId) {
        PartsResponseDto responseDto = new PartsResponseDto();
        responseDto.setParts(partRepository.searchPartByBrandOrCustomerIdOrFamilyOrIdOrQuantityOrShippingIdOrWarehouseId(brand,customerId,
                family,Id,quantity,shippingId,warehouseId));
        return responseDto;
    }

    @Override
    public Optional<Part> searchById(String id) {
        return partRepository.findById(id);
    }




}
