package com.americar.ecommerceapi.dto;

import com.americar.ecommerceapi.entity.OrderDeparture;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class OrdersDepartureResponseDto {
    @JsonInclude()
    private List<OrderDeparture> ordersDeparture;
}
