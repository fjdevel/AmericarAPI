package com.americar.ecommerceapi.service.impl;

import com.americar.ecommerceapi.dto.SellersResponseDto;
import com.americar.ecommerceapi.entity.Seller;
import com.americar.ecommerceapi.repository.ISellerRepository;
import com.americar.ecommerceapi.service.ISellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SellerService implements ISellerService {
    @Autowired
    ISellerRepository repository;

    @Override
    public SellersResponseDto searchSellers(String account, String entrydate, String leavingDate, String name) {
        SellersResponseDto responseDto = new SellersResponseDto();
        responseDto.setSellers(repository.findAllByAccountOrEntryDateOrLeavingDateOrName(account, entrydate, leavingDate, name));
        return responseDto;
    }

    @Override
    public Optional<Seller> searchById(String id) {
        return repository.findById(id);
    }
}
