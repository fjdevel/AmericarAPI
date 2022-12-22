package com.americar.ecommerceapi.repository;

import com.americar.ecommerceapi.entity.CodeShipping;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ICodeShippingRepository extends JpaRepository<CodeShipping, String> {

    List<CodeShipping> findCodeShippingByAccount(String account);
}
