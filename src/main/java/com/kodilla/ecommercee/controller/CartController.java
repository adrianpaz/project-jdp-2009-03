package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.*;
import com.kodilla.ecommercee.mapper.CartMapper;
import com.kodilla.ecommercee.service.DbCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/ecommerce/cart")
public class CartController {
    @Autowired
    private CartMapper cartMapper;
    @Autowired
    private DbCartService dbCartService;

    @PostMapping(value = "createCart")
    public void createCart(@RequestBody CartDto cartDto){
        dbCartService.saveCart(cartMapper.mapToCart(cartDto));
    }

    @GetMapping(value = "getCart")
    public List<Cart> getCart(@RequestParam Long id){
        return new ArrayList<>();
    }

    @PutMapping(value = "addProductToCart")
    public void addProductToCart(@RequestParam Long productId){
    }

    @DeleteMapping(value = "deleteProduct")
    public void deleteProduct(@RequestParam Long productId){
        dbCartService.deleteCart(productId);
    }

    @PutMapping(value = "createOrder")
    public Order createOrder(@RequestParam Long cartId){
        return dbCartService.createOrder(cartId);
    }
}
