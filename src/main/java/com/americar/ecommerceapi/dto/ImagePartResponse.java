package com.americar.ecommerceapi.dto;

import com.americar.ecommerceapi.entity.ImagePart;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Optional;

@Data
@NoArgsConstructor
public class ImagePartResponse {
    @JsonInclude()
    List<Optional<ImagePart>> imagePart;
}
