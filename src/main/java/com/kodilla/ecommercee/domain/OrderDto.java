package com.kodilla.ecommercee.domain;

import java.util.ArrayList;
import java.util.List;

public class OrderDto {

    private Long id;
    private List<ProductDto> orderedProducts;

    public OrderDto() {
    }

    public OrderDto(Long id, List<ProductDto> orderedProducts) {
        this.id = id;
        this.orderedProducts = new ArrayList<>(orderedProducts);
    }

    public Long getId() {
        return id;
    }

    public List<ProductDto> getOrderedProducts() {
        return orderedProducts;
    }
}


