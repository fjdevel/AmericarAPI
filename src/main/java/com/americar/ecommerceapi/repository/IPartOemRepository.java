package com.americar.ecommerceapi.repository;

import com.americar.ecommerceapi.entity.PartOEM;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface IPartOemRepository extends JpaRepository<PartOEM,String> {
    List<PartOEM> findByBrandOrDescriptionOrEntryDateOrFamilyOrId(String brand, String description, Date entryDate,String family,String id);
}
