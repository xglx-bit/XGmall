package com.xlx.dto.productDomain.sku;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductSkuListDTO {
    private Long id;
    private Long productId;
    private String skuCode;
    private BigDecimal price;
    private BigDecimal costPrice;
    private Integer stock;
    private Integer status;
}
