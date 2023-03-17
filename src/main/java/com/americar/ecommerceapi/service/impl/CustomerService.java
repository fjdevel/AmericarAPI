package com.americar.ecommerceapi.service.impl;

import com.americar.ecommerceapi.dto.CustomerCreateDto;
import com.americar.ecommerceapi.dto.CustomersResponse;
import com.americar.ecommerceapi.entity.Customer;
import com.americar.ecommerceapi.repository.ICustomerRepository;
import com.americar.ecommerceapi.service.ICustomerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
public class CustomerService implements ICustomerService {
    @Autowired
    ICustomerRepository customerRepository;
    @Autowired
    private WebClient webClient;

    @Override
    public Customer createCustomer(CustomerCreateDto data) {
        return null;
    }

    @Override
    public List<CustomersResponse> getCustomers(String name, String id, String documentId, String address, String phoneNumber) {
        ResponseEntity<List<CustomersResponse>> responseEntity =
                webClient.get()
                        .uri(uriBuilder -> uriBuilder
                                .path("/customers")
                                .queryParamIfPresent("name", Optional.ofNullable(name))
                                .queryParamIfPresent("id", Optional.ofNullable(id))
                                .queryParamIfPresent("documentId", Optional.ofNullable(documentId))
                                .queryParamIfPresent("address", Optional.ofNullable(address))
                                .queryParamIfPresent("phoneNumber", Optional.ofNullable(phoneNumber))
                                .build())
                        .retrieve()
                        .toEntity(new ParameterizedTypeReference<List<CustomersResponse>>() {})
                        .block();

        if (responseEntity != null && responseEntity.getStatusCode().is2xxSuccessful()) {
            return responseEntity.getBody();
        }

        throw new RuntimeException("Error retrieving customers from API");
    }

    @Override
    public Optional<Customer> findById(String id) {
        return Optional.empty();
    }
}
