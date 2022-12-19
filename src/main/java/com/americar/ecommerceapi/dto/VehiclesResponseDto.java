package com.americar.ecommerceapi.dto;

import com.americar.ecommerceapi.entity.Vehicle;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class VehiclesResponseDto {

    @JsonInclude
    private List<Vehicle> vehicles;
}
