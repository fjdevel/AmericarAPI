package com.americar.ecommerceapi.dto;

import com.americar.ecommerceapi.entity.CodeShipping;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class CodeShippingResponseDto {

    @JsonInclude(JsonInclude.Include.ALWAYS)
    private List<CodeShipping> codeShipping;
}
