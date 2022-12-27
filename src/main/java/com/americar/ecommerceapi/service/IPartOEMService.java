package com.americar.ecommerceapi.service;

import com.americar.ecommerceapi.dto.PartsOEMResponse;

import java.util.Date;

public interface IPartOEMService {

    public PartsOEMResponse searchPartOEM(String brand, String description, Date entryDate, String family, String id);
}
