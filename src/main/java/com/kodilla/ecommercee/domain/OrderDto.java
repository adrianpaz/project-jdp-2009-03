package com.kodilla.ecommercee.domain;

import java.util.List;

public class OrderDto {

    private Long id;
    private Long userId;
    private List<ProductDto> orderedProducts;

    public OrderDto() {
    }

    public OrderDto(Long id, Long userId, List<ProductDto> orderedProducts) {
        this.id = id;
        this.userId = userId;
        this.orderedProducts = orderedProducts;
    }

    public Long getId() {
        return id;
    }

    public Long getUserId() {
        return userId;
    }

    public List<ProductDto> getOrderedProducts() {
        return orderedProducts;
    }
}