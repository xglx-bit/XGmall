package com.xlx.dto.productDomain.attribute;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ProductAttributeDetailDTO {
    private Long id;
    private String attrName;
    private String attrValue;
    private Integer sortOrder;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
