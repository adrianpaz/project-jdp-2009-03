package com.kodilla.ecommercee.domain;

import java.util.ArrayList;
import java.util.List;

public class CartDto {
    private Long id;
    private List<ProductDto> productDtoList = new ArrayList<>();
    private List<ItemDto> itemsDtoList = new ArrayList<>();

    public CartDto(Long id, List<ItemDto> itemsDtoList) {
        this.id = id;
        this.itemsDtoList = itemsDtoList;
    }

    public Long getId() {
        return id;
    }

    public List<ProductDto> getProductDtoList() {
        return productDtoList;
    }

    public List<ItemDto> getItemsDtoList() {
        return itemsDtoList;
    }
}
