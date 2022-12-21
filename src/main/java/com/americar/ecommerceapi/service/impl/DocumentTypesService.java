package com.americar.ecommerceapi.service.impl;

import com.americar.ecommerceapi.entity.DocumentsTypes;
import com.americar.ecommerceapi.repository.IDocumentTypeRepository;
import com.americar.ecommerceapi.service.IDocumentTypesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DocumentTypesService implements IDocumentTypesService {
    @Autowired
    IDocumentTypeRepository documentTypeRepository;
    @Override
    public List<DocumentsTypes> findByName(String name) {
        return documentTypeRepository.findAllByName(name);
    }

    @Override
    public Optional<DocumentsTypes> findById(String id) {
        return documentTypeRepository.findById(id);
    }
}
