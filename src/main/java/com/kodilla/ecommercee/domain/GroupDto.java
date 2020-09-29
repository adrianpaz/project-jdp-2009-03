package com.kodilla.ecommercee.domain;

import java.util.ArrayList;
import java.util.List;

public class GroupDto {
    private Long id;
    private String name;
    private List<ProductDto> products = new ArrayList<>();

    public GroupDto(Long id, String name, List<ProductDto> products) {
        this.id = id;
        this.name = name;
        this.products = products;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<ProductDto> getProducts() {
        return products;
    }
}
