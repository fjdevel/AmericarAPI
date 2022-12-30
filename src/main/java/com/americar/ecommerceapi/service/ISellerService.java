package com.americar.ecommerceapi.service;


import com.americar.ecommerceapi.dto.SellersResponseDto;
import com.americar.ecommerceapi.entity.Seller;

import java.util.Optional;

public interface ISellerService {
    SellersResponseDto searchSellers(String account,String entrydate,String leavingDate,String name);

    Optional<Seller> searchById(String id);
}
