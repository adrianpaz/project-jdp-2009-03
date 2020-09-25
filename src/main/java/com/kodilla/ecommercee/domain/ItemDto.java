package com.kodilla.ecommercee.domain;

import java.math.BigDecimal;

public class ItemDto {
    private Long id;
    private Long productId;
    private Integer quantity;

    public ItemDto(Long id, Long productId, Integer quantity) {
        this.id = id;
        this.productId = productId;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public Long getProductId() {
        return productId;
    }

    public Integer getQuantity() {
        return quantity;
    }
}
