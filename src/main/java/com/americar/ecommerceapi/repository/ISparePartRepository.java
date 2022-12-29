package com.americar.ecommerceapi.repository;

import com.americar.ecommerceapi.entity.Part;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ISparePartRepository extends JpaRepository<Part,String> {
    List<Part> findAllByBrandOrCustomerIdOrFamilyOrIdOrQuantityOrShippingIdOrWarehouseIdIn(String brand,String customerId,
                                                                                            String family, String Id,
                                                                                            Integer quantity, String shippingId,
                                                                                            List<String> warehouseId);
}
