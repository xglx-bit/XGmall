package com.xlx.dto.productDomain.product;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import com.xlx.dto.productDomain.sku.ProductSkuSaveDTO;

@Data
public class ProductDetailDTO {
    private Long id;
    private String skuPrefix;
    private String name;
    private String subtitle;
    private String description;
    private String brandName;
    private String categoryName;
    private BigDecimal defaultPrice;
    private Integer status;
    private String defaultImage;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    private List<String> imageUrls;
    private List<ProductSkuSaveDTO> skus;

}
