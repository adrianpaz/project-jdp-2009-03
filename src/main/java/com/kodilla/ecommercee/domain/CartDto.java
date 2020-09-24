package com.kodilla.ecommercee.domain;

import java.util.ArrayList;
import java.util.List;

public class CartDto {
    private Long id;
    private List<ProductDto> productDtoList = new ArrayList<>();

    public CartDto(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public List<ProductDto> getProductDtoList() {
        return productDtoList;
    }
}
