package com.americar.ecommerceapi.service;


import com.americar.ecommerceapi.dto.CustomerCreateDto;
import com.americar.ecommerceapi.dto.CustomersResponse;
import com.americar.ecommerceapi.entity.Customer;

import java.util.List;
import java.util.Optional;

public interface ICustomerService {
    public Customer createCustomer(CustomerCreateDto data);
    List<CustomersResponse> getCustomers(String name, String id, String documentId, String address, String phoneNumber);
    public Optional<Customer> findById(String id);
}
