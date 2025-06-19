package com.xlx.dto.productDomain.category;

import lombok.Data;

@Data
public class ProductCateListDTO {
    private Long id;
    private Long parentId;
    private String name;
    private Integer level;
    private Integer sortOrder;
}
