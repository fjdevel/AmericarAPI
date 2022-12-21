package com.americar.ecommerceapi.service;

import com.americar.ecommerceapi.entity.CodeShipping;

import java.util.List;

public interface ICodeShippingService {
    public List<CodeShipping> findByAccount(String account);
}
