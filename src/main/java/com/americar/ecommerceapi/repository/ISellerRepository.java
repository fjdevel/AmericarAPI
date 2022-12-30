package com.americar.ecommerceapi.repository;

import com.americar.ecommerceapi.entity.Seller;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ISellerRepository extends JpaRepository<Seller,String> {
    List<Seller> findAllByAccountOrEntryDateOrLeavingDateOrName(String account,String entrydate,String leavingDate,String name);
}
