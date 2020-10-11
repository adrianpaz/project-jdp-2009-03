package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.*;
import com.kodilla.ecommercee.mapper.CartMapper;
import com.kodilla.ecommercee.mapper.ItemMapper;
import com.kodilla.ecommercee.service.DbCartService;
import com.kodilla.ecommercee.service.DbItemService;
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
    @Autowired
    private ItemMapper itemMapper;
    @Autowired
    private DbItemService dbItemService;

    @PostMapping(value = "createCart")
    public void createCart(){
        dbCartService.saveCart(new Cart());
    }

    @GetMapping(value = "getCart")
    public List<Cart> getCart(@RequestParam Long id) {
        return new ArrayList<>();
    }

    @GetMapping(value = "getCarts")
    public List<CartDto> getCarts() {
        return cartMapper.mapToCartDtoList(dbCartService.getAllCards());
    }

    @PostMapping(value = "addItemToCart")
    public void addItemToCart(@RequestBody ItemDto itemDto) throws ProductNotFoundException,
            CartNotFoundException, ItemNotFoundException {
        dbItemService.createItem(itemDto);
    }

    @DeleteMapping(value = "deleteItem")
    public void deleteItem (@RequestParam Long id) throws ItemNotFoundException{
        dbItemService.deleteItem(id);
    }

    @PutMapping(value = "createOrder")
    public Order createOrder(@RequestParam Long cartId){
        return dbCartService.createOrder(cartId);
    }
}
