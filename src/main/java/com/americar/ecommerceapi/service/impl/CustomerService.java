package com.americar.ecommerceapi.service.impl;

import com.americar.ecommerceapi.dto.CustomerCreateDto;
import com.americar.ecommerceapi.entity.Customer;
import com.americar.ecommerceapi.repository.ICustomerRepository;
import com.americar.ecommerceapi.service.ICustomerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class CustomerService implements ICustomerService {
    @Autowired
    ICustomerRepository customerRepository;

    private final ModelMapper modelMapper;

    @Autowired
    public CustomerService(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }



    @Override
    public Customer createCustomer(CustomerCreateDto data) {
        Customer customer = new Customer();
        String uuid =UUID.randomUUID().toString();
        modelMapper.map(data,customer);
        customer.setId(uuid);
        return customerRepository.save(customer);
    }


    @Override
    public List<Customer> searchCustomer(String address, String documentId, String id, String name, List<String> phoneNumbers) {
        return customerRepository.findCustomerByAddressOrDocumentIdOrIdOrNameOrPhoneNumberIn(address,documentId,id,name,phoneNumbers);
    }

    @Override
    public Optional<Customer> findById(String id) {
        return customerRepository.findById(id);
    }
}
