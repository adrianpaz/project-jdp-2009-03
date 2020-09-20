package com.kodilla.ecommercee.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CartDto {
    private Long cartId;
    private String name;
    private String description;
    private BigDecimal price;
    private String groupId;
    private Long orderId;
    private List<ProductDto> productDtoList = new ArrayList<>();

    public CartDto(Long cartId, String name, String description, BigDecimal price, String groupId, Long orderId) {
        this.cartId = cartId;
        this.name = name;
        this.description = description;
        this.price = price;
        this.groupId = groupId;
        this.orderId = orderId;
    }

    public Long getCartId() {
        return cartId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getGroupId() {
        return groupId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public List<ProductDto> getProductDtoList() {
        return productDtoList;
    }
}
