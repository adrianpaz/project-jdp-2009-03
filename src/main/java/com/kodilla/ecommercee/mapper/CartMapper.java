package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.*;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CartMapper {

    public Cart mapToCart(final CartDto cartDto) {
        return new Cart(
                cartDto.getItemsDtoList());
    }

    public CartDto mapToCartDto(Cart cart) {
        return new CartDto(
                cart.getId());
    }

    public List<CartDto> mapToCartDtoList(final List<Cart> cartList) {
        return cartList.stream()
                .map(b -> mapToCartDto(b))
                .collect(Collectors.toList());
    }
}
