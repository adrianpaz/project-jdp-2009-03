package com.kodilla.ecommercee.domain;

import java.util.ArrayList;
import java.util.List;

public class CartDto {
    private List<ProductDto> productDtoList = new ArrayList<>();

    public List<ProductDto> getProductDtoList() {
        return productDtoList;
    }
}