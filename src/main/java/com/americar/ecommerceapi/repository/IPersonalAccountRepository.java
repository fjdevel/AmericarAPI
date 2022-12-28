package com.americar.ecommerceapi.repository;

import com.americar.ecommerceapi.entity.PersonalAccountsCategories;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IPersonalAccountRepository extends JpaRepository<PersonalAccountsCategories,String> {
    List<PersonalAccountsCategories> findByDescriptionOrType(String description, String type);
}
