package com.xlx.dto.productDomain.image;

import lombok.Data;

@Data
public class ProductImageListDTO {
    private Long id;
    private String imageUrl;
    private Boolean isDefault;
    private Integer sortOrder;
}
