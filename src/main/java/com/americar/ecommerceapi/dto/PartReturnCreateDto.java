package com.americar.ecommerceapi.dto;

import com.americar.ecommerceapi.entity.PartReturns;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class PartReturnCreateDto {

    @JsonInclude()
    private String customerId;

    @JsonInclude()
    private String deliveryNote;

    @JsonInclude()
    private List<PartReturns> partsReturns;
}
