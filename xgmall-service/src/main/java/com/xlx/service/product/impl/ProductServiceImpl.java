package com.xlx.service.product.impl;

import com.xlx.dto.productDomain.product.ProductSaveDTO;
import com.xlx.repository.product.ProductRepository;
import com.xlx.service.product.ProductService;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository){
        this.productRepository =  productRepository;
    }

    @Override
    public void productAdd(ProductSaveDTO productSaveDTO){
        if (productRepository.existsByName(productSaveDTO.getName())){
            throw new RuntimeException("The product has been existed which you want to putaway");
        }


    }




}
