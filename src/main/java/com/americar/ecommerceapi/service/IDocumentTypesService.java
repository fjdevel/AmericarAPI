package com.americar.ecommerceapi.service;

import com.americar.ecommerceapi.entity.DocumentsTypes;

import java.util.List;
import java.util.Optional;

public interface IDocumentTypesService {
    public List<DocumentsTypes> findByName(String name);

    public Optional<DocumentsTypes> findById(String id);
}
