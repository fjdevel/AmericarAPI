package com.americar.ecommerceapi.service;


import com.americar.ecommerceapi.dto.CustomerCreateDto;
import com.americar.ecommerceapi.entity.Customer;

import java.util.List;
import java.util.Optional;

public interface ICustomerService {
    public Customer createCustomer(CustomerCreateDto data);
    public List<Customer> searchCustomer(String address, String documentId, String id, String name, List<String> phoneNumbers);

    public Optional<Customer> findById(String id);
}
