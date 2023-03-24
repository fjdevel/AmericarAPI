package com.americar.ecommerceapi.service;


import com.americar.ecommerceapi.dto.CustomerCreateDto;
import com.americar.ecommerceapi.dto.CustomersResponse;
import com.americar.ecommerceapi.entity.Customer;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Optional;

public interface ICustomerService {
    CustomersResponse getCustomers(String name, String id, String documentId, String address, String phoneNumber) throws IOException, NoSuchAlgorithmException, KeyStoreException, KeyManagementException;
    Customer createCustomer(CustomerCreateDto data) throws IOException;
}
