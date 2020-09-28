package com.kodilla.ecommercee.domain;

import java.util.ArrayList;
import java.util.List;

public class GroupDto {
    private Long id;
    private String name;
    private List<Product> products = new ArrayList<>();

    public GroupDto(Long id, String name, List<Product> products) {
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

    public List<Product> getProducts() {
        return products;
    }
}
