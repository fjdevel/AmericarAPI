package com.americar.ecommerceapi.dto;


import com.americar.ecommerceapi.entity.DocumentsTypes;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class DocumentsTypesResponseDto {
    @JsonInclude()
    private List<DocumentsTypes> sellers;
}
