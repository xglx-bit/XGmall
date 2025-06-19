package com.xlx.dto.productDomain.image;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ProductImageDetailDTO {
    private Long id;
    private Long productId;
    private String imageUrl;
    private Boolean isDefault;
    private Integer sortOrder;

    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
