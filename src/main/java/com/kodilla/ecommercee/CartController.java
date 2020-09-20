package com.kodilla.ecommercee;

import com.kodilla.ecommercee.domain.CartDto;
import com.kodilla.ecommercee.domain.ProductDto;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/ecommercee/cart")
public class CartController {

    @RequestMapping(method = RequestMethod.POST, value = "createCart")
    public void createCart(@RequestBody CartDto cartDto){
    }

    @RequestMapping(method = RequestMethod.GET, value = "getProducts")
    public List<ProductDto> getProducts(@RequestParam List<ProductDto> productDtoList){
        return productDtoList;
    }

    @RequestMapping(method = RequestMethod.PUT, value = "addProduct")
    public List<ProductDto> addProductToCart(){
        List<ProductDto> cart = new ArrayList<>();
        cart.add(new ProductDto(1L, "Neckles", "silver", new BigDecimal(100), "3"));
        cart.add(new ProductDto(2L, "T-shirt", "cotton", new BigDecimal(50), "1"));
        cart.add(new ProductDto(3L, "Dress", "cotton", new BigDecimal(250), "1"));
        return cart;
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteProduct")
    public void deleteProduct(@RequestParam Long productId){
        
    }

    @RequestMapping(method = RequestMethod.PUT, value = "createOrder")
    public CartDto createOrder(@RequestBody CartDto cartDto){
        return new CartDto(1L, "Neckles", "silver", new BigDecimal(100), "3", 1L);
    }
}
