package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class CartDto {
    private Long id;
    private List<ProductDto> productDtoList = new ArrayList<>();

    public CartDto(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public List<ProductDto> getProductDtoList() {
        return productDtoList;
    }

    @Getter
    @AllArgsConstructor
    public static class UserDto {

        private Long id;
        private String userName;
        private String status;
        private Long userKey;

    }
}
