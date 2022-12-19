package com.americar.ecommerceapi.dto;

import com.americar.ecommerceapi.entity.Brand;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class BrandsResponseDto {

    @JsonInclude(JsonInclude.Include.ALWAYS)
    private List<Brand> brands;
}
