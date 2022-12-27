package com.americar.ecommerceapi.repository;

import com.americar.ecommerceapi.entity.PartReturns;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPartReturnRepository extends JpaRepository<PartReturns,String> {
}
