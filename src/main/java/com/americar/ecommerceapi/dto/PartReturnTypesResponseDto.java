package com.americar.ecommerceapi.dto;

import com.americar.ecommerceapi.entity.PartReturnType;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@NoArgsConstructor
public class PartReturnTypesResponseDto {
    @JsonInclude()
    private List<PartReturnType> partsReturnTypes;
}