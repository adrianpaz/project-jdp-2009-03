package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.controller.GroupNotFoundException;
import com.kodilla.ecommercee.controller.UserNotFoundException;
import com.kodilla.ecommercee.domain.*;
import com.kodilla.ecommercee.service.DbUserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

public class UserMapper {

    @Autowired
    private DbUserService service;

    public User mapToUser(final UserDto userDto) {

        return new User(userDto.getUserName(),userDto.getUserKey(),userDto.);
    }

    public ProductDto mapToProductDto(final Product product) {
        return new ProductDto(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getGroup().getId().toString());
    }

    public List<ProductDto> mapToProductDtoList(final List<Product> productList) {
        return productList.stream()
                .map(p -> mapToProductDto(p))
                .collect(Collectors.toList());
    }
}
