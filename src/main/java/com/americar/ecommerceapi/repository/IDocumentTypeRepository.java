package com.americar.ecommerceapi.repository;

import com.americar.ecommerceapi.entity.DocumentsTypes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IDocumentTypeRepository extends JpaRepository<DocumentsTypes,String> {
    public List<DocumentsTypes> findAllByName(String name);
}
