package com.americar.ecommerceapi.repository;

import com.americar.ecommerceapi.entity.OrderType;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IOrderTypesRepository extends PagingAndSortingRepository<OrderType,String> {

}
