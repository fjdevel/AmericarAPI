package com.americar.ecommerceapi.dto;

import javax.persistence.*;import java.util.UUID;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
public class ErrorDto {
    @Column()
    private String code;

    @Column()
    private String message;
}
