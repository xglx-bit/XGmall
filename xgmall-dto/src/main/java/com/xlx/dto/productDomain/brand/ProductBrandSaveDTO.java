package com.xlx.dto.productDomain.brand;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ProductBrandSaveDTO {
    @NotBlank
    private String name;

    @NotNull
    private String logoUrl;

    @NotBlank
    private String description;
}
