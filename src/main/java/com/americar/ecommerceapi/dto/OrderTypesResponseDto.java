package com.americar.ecommerceapi.dto;

import com.americar.ecommerceapi.entity.OrderType;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class OrderTypesResponseDto {
    @JsonInclude(JsonInclude.Include.ALWAYS)
    private List<OrderType> orderTypes;
}
