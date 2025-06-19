package com.xlx.dto.productDomain.sku;

import com.xlx.dto.productDomain.attribute.ProductAttributeSaveDTO;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class ProductSkuDetailDTO {
    private Long id;
    private Long productId;
    private String skuCode;
    private BigDecimal price;
    private BigDecimal costPrice;
    private Integer stock;
    private BigDecimal volume;
    private Integer status;
    private List<ProductAttributeSaveDTO> attributes;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
