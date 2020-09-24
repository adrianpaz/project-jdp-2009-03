package com.kodilla.ecommercee;

import com.kodilla.ecommercee.domain.CartDto;
import com.kodilla.ecommercee.domain.OrderDto;
import com.kodilla.ecommercee.domain.ProductDto;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/ecommerce/cart")
public class CartController {

    @RequestMapping(method = RequestMethod.POST, value = "createCart")
    public void createCart(){
    }

    @RequestMapping(method = RequestMethod.GET, value = "getCart")
    public List<ProductDto> getCart(@RequestParam Long id){
        List<ProductDto> cart = new ArrayList<>();
        cart.add(new ProductDto(1L, "Neckles", "silver", new BigDecimal(100), "3"));
        cart.add(new ProductDto(2L, "T-shirt", "cotton", new BigDecimal(50), "1"));
        cart.add(new ProductDto(3L, "Dress", "cotton", new BigDecimal(250), "1"));
        return new ArrayList<>(cart);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "addProductToCart")
    public void addProductToCart(@RequestParam Long productId){
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteProduct")
    public void deleteProduct(@RequestParam Long productId){
    }

    @RequestMapping(method = RequestMethod.PUT, value = "createOrder")
    public OrderDto createOrder(@RequestBody CartDto cartDto){
        return new OrderDto();
    }
}
