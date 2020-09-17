package com.kodilla.ecommercee.domain;

public class ProductDto {
    private Long id;
    private String name;
    private String description;
    private Double price;
    private String groupId;

    public ProductDto(Long id, String name, String description, Double price, String groupId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.groupId = groupId;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public String getGroupId() {
        return groupId;
    }
}
