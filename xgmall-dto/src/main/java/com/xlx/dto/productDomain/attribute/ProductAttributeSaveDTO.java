package com.xlx.dto.productDomain.attribute;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ProductAttributeSaveDTO {
    @NotNull
    private Long productId;

    @NotNull
    private String attrName;

    @NotNull
    private String attrValue;

    private Integer sortOrder;
}
