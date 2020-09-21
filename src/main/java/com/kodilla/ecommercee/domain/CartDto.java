package com.kodilla.ecommercee.domain;

import java.util.ArrayList;
import java.util.List;

public class CartDto {
    private Long cartId;
    private List<ProductDto> productDtoList = new ArrayList<>();

    public CartDto(Long cartId) {
        this.cartId = cartId;
    }

    public Long getCartId() {
        return cartId;
    }

    public List<ProductDto> getProductDtoList() {
        return productDtoList;
    }
}
