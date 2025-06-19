package com.xlx.dto.productDomain.product;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductListDTO {
    private Long id;
    private String name;
    private BigDecimal defaultPrice;
    private String defaultImage;
    private Integer status;
}
