package com.xlx.dto.productDomain.attribute;

import lombok.Data;

@Data
public class ProductAttributeListDTO {
    private Long id;
    private String attrName;
    private String attrValue;
    private Integer sortOrder;
}