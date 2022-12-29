package com.americar.ecommerceapi.repository;

import com.americar.ecommerceapi.entity.ReservedItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IReservedItemRepository extends JpaRepository<ReservedItem,String> {
}
