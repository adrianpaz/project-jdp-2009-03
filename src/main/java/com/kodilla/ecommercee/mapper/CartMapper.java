package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CartMapper {
    @Autowired
    private final ItemMapper itemMapper;

    public CartMapper(ItemMapper itemMapper) {
        this.itemMapper = itemMapper;
    }

    public CartDto mapToCartDto(Cart cart) {
        return new CartDto(
                cart.getId(),
                itemMapper.mapToItemDtoList(cart.getItems()));
    }

    public List<CartDto> mapToCartDtoList(final List<Cart> cartList) {
        return cartList.stream()
                .map(b -> mapToCartDto(b))
                .collect(Collectors.toList());
    }
}
