package com.xlx.dto.productDomain.image;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ProductImageSaveDTO {
    @NotNull
    private Long productId;

    @NotBlank
    private String imageUrl;

    @NotNull
    private Boolean isDefault;

    private Integer sortOrder;
}
