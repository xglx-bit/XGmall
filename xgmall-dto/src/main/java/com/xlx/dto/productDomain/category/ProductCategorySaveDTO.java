package com.xlx.dto.productDomain.category;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ProductCategorySaveDTO {
    @NotNull
    private Long parentId;

    @NotBlank
    private String name;

    private Integer level;


    private Integer sortOrder;
}
