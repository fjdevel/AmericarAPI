package com.americar.ecommerceapi.dto;

import com.americar.ecommerceapi.entity.Part;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class PartsResponseDto {
    @JsonInclude
    private List<Part> parts;
}
