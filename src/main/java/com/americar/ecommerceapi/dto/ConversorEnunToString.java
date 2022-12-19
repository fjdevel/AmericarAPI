package com.americar.ecommerceapi.dto;


import javax.persistence.AttributeConverter;

public class ConversorEnunToString implements AttributeConverter<SNEnum, String> {
    @Override
    public String convertToDatabaseColumn(SNEnum miEnum) {
        switch (miEnum) {
            case S:
                return SNEnum.S.toString();
            default:
                return SNEnum.N.toString();
        }
    }

    @Override
    public SNEnum convertToEntityAttribute(String stringValue) {
        if (stringValue.equals(SNEnum.S.toString())) {
            return SNEnum.S;
        } else {
            return SNEnum.N;
        }
    }
}
