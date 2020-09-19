package com.kodilla.ecommercee.domain;

public class CartDto {
    private ProductDto productDto;
    private Long orderId;
    private Long quantity;

    public CartDto(ProductDto productDto, Long orderId, Long quantity) {
        this.productDto = productDto;
        this.orderId = orderId;
        this.quantity = quantity;
    }

    public ProductDto getProductDto() {
        return productDto;
    }

    public Long getOrderId() {
        return orderId;
    }

    public Long getQuantity() {
        return quantity;
    }
}
