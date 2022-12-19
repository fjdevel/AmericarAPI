package com.americar.ecommerceapi.dto;

import com.americar.ecommerceapi.entity.Customer;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class CustomersResponse {
    @JsonInclude()
    private List<Customer> customers;
}
