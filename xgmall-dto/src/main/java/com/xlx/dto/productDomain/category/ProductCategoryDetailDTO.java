package com.xlx.dto.productDomain.category;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ProductCategoryDetailDTO {
    private Long id;
    private Long parentId;
    private String name;
    private Integer level;
    private Integer sortOrder;

    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
