package com.xlx.dto.productDomain.product;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductSaveDTO {

    @NotBlank(message = "skuPrefix 不能为空")
    private String skuPrefix;


    @NotBlank(message = "name 不能为空")
    private String name;


    @Size(max = 255, message = "subtitle 最多 255 字符")
    private String subtitle;


    private String description;


    @NotNull(message = "brandId 不能为空")
    private Long brandId;


    @NotNull(message = "categoryId 不能为空")
    private Long categoryId;


    @NotNull(message = "defaultPrice 不能为空")
    @DecimalMin(value = "0.01", message = "defaultPrice 最小为 0.01")
    private BigDecimal defaultPrice;


    @Pattern(
            regexp = "^(https?://).+$",
            message = "defaultImage 必须是合法的 URL，且以 http:// 或 https:// 开头"
    )
    private String defaultImage;

    @NotNull(message = "status 不能为空")
    @Min(value = 0, message = "status 最小为 0")
    @Max(value = 1, message = "status 最大为 1")
    private Integer status;

}
