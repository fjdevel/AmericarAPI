package com.americar.ecommerceapi.service;


import com.americar.ecommerceapi.dto.PartsResponseDto;
import com.americar.ecommerceapi.entity.Part;

import java.util.List;
import java.util.Optional;

public interface ISparePartService {
    public PartsResponseDto searchPart(String brand, String customerId,
                                       String family, String Id,
                                       Integer quantity, String shippingId,
                                       List<String>warehouseId);

    public Optional<Part> searchById(String id);

}
