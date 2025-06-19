package com.xlx.dto.productDomain.sku;

import com.xlx.dto.productDomain.attribute.ProductAttributeSaveDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class ProductSkuSaveDTO {
    @NotNull(message = "productId 不能为空")
    private Long productId;

    @NotBlank(message = "skuCode 不能为空")
    private String skuCode;

    @NotNull(message = "price 不能为空")
    @DecimalMin(value = "0.01", message = "price 最小为 0.01")
    private BigDecimal price;

    @NotNull(message = "costPrice 不能为空")
    @DecimalMin(value = "0.00", inclusive = true, message = "costPrice 最小为 0.00")
    private BigDecimal costPrice;

    @NotNull(message = "stock 不能为空")
    @Min(value = 0, message = "stock 最小为 0")
    private Integer stock;

    @DecimalMin(value = "0.0", inclusive = true, message = "volume 必须 ≥ 0")
    private Double volume;

    @DecimalMin(value = "0.0", inclusive = true, message = "weight 必须 ≥ 0")
    private Double weight;

    @NotNull(message = "status 不能为空")
    @Min(value = 0, message = "status 最小为 0")
    @Max(value = 1, message = "status 最大为 1")
    private Integer status;

    @NotEmpty(message = "attributes 不能为空")
    @Valid
    private List<ProductAttributeSaveDTO> attributes;
}
