package com.xlx.dto.productDomain.brand;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ProductBrandDetailDTO {
    private Long id;
    private String name;
    private String logoUrl;
    private String description;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
