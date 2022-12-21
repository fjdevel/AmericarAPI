package com.americar.ecommerceapi.repository;

import com.americar.ecommerceapi.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ICustomerRepository extends JpaRepository<Customer, String> {
    List<Customer> findCustomerByAddressOrDocumentIdOrIdOrNameOrPhoneNumberIn(String address,String documentId,String id,String name,List<String> phoneNumbers);
}
