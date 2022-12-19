package com.americar.ecommerceapi.dto;

import com.americar.ecommerceapi.entity.PartOEM;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class PartsOEMResponse {
    @JsonInclude(JsonInclude.Include.ALWAYS)
    private List<PartOEM> parts;
}
