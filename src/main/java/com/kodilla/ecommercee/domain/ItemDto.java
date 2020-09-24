package com.kodilla.ecommercee.domain;

import java.math.BigDecimal;

public class ItemDto {
    private Long id;
    private Long productId;
    private Integer quantity;
    private BigDecimal value;

    public ItemDto(Long id, Long productId, Integer quantity) {
        this.id = id;
        this.productId = productId;
        this.quantity = quantity;
        this.value = new BigDecimal("99.99");
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

    public BigDecimal getValue() {
        return value;
    }
}
