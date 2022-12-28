package com.americar.ecommerceapi.dto;

import com.americar.ecommerceapi.entity.Reservation;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class ReservationResponse {
    @JsonInclude
    private List<Reservation> reservations;
}
