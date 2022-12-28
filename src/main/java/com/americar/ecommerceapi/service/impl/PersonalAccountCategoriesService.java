package com.americar.ecommerceapi.service.impl;

import com.americar.ecommerceapi.dto.PersonalAccountsCategoriesResponseDto;
import com.americar.ecommerceapi.entity.PersonalAccountsCategories;
import com.americar.ecommerceapi.repository.IPersonalAccountRepository;
import com.americar.ecommerceapi.service.IPersonalAccountCategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonalAccountCategoriesService implements IPersonalAccountCategoriesService {
    @Autowired
    IPersonalAccountRepository personalAccountRepository;

    @Override
    public PersonalAccountsCategoriesResponseDto searchPersonalAccountsCategories(String description, String type) {
        PersonalAccountsCategoriesResponseDto responseDto  = new PersonalAccountsCategoriesResponseDto();
        responseDto.setCategories(personalAccountRepository.findByDescriptionOrType(description,type));
        return responseDto;
    }

    @Override
    public Optional<PersonalAccountsCategories> searchById(String id) {
        return personalAccountRepository.findById(id);
    }
}
