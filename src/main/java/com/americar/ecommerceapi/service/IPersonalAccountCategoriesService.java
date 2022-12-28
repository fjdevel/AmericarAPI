package com.americar.ecommerceapi.service;

import com.americar.ecommerceapi.dto.PersonalAccountsCategoriesResponseDto;
import com.americar.ecommerceapi.entity.PersonalAccountsCategories;

import java.util.Optional;

public interface IPersonalAccountCategoriesService {
    public PersonalAccountsCategoriesResponseDto searchPersonalAccountsCategories(String description,String type);

    public Optional<PersonalAccountsCategories> searchById(String id);
}
