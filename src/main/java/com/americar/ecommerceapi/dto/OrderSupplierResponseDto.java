package com.americar.ecommerceapi.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class OrderSupplierResponseDto {
    @JsonInclude()
    private String referenceProviderOrder;
}
