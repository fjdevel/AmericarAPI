package com.americar.ecommerceapi.service.impl;

import com.americar.ecommerceapi.dto.PartsOEMResponse;
import com.americar.ecommerceapi.repository.IPartOemRepository;
import com.americar.ecommerceapi.service.IPartOEMService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class PartOEMService implements IPartOEMService {
    @Autowired
    IPartOemRepository partOemRepository;

    @Override
    public PartsOEMResponse searchPartOEM(String brand, String description, Date entryDate, String family, String id) {
        PartsOEMResponse response = new PartsOEMResponse();
        response.setParts(partOemRepository.findByBrandOrDescriptionOrEntryDateOrFamilyOrId(brand, description, entryDate, family, id));
        return response;
    }
}
