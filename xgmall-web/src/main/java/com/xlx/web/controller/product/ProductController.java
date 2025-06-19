package com.xlx.web.controller.product;

import com.xlx.common.response.CommonResult;
import com.xlx.dto.productDomain.product.ProductSaveDTO;
import com.xlx.service.product.ProductService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    private final ProductService productService;

    public  ProductController(ProductService productService) {
        this.productService = productService;
    }


    @RequestMapping("/product-putaway")
    public CommonResult<Void> addProduct(@RequestBody @Valid ProductSaveDTO productSaveDTO ) {
        productService.productAdd(productSaveDTO);
        return CommonResult.success(200,"Add successful!",null);

    }
}
