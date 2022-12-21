package com.americar.ecommerceapi.service.impl;


import com.americar.ecommerceapi.entity.CodeShipping;
import com.americar.ecommerceapi.repository.ICodeShippingRepository;
import com.americar.ecommerceapi.service.ICodeShippingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CodeShippingService implements ICodeShippingService {

    @Autowired
    ICodeShippingRepository codeShippingRepository;

    @Override
    public List<CodeShipping> findByAccount(String account) {
        return codeShippingRepository.findCodeShippingByAccount(account);
    }
}
