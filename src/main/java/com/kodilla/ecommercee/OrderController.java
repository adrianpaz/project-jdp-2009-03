package com.kodilla.ecommercee;

import com.kodilla.ecommercee.domain.OrderDto;
import com.kodilla.ecommercee.domain.ProductDto;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/ecommerce/order")
public class OrderController {

    @GetMapping(value = "getOrders")
    public List<OrderDto> getOrders() {
        List<OrderDto> orders = new ArrayList<>();
        return orders;
    }

    @GetMapping(value = "getOrder")
    public OrderDto getOrder(@RequestParam Long orderId) {

        List<ProductDto> orderedProducts = new ArrayList<>();
        orderedProducts.add(new ProductDto(1L, "test product", "test description", new BigDecimal("27.99"), "1"));
        orderedProducts.add(new ProductDto(2L, "test product 2", "test description", new BigDecimal("39.99"), "2"));
        OrderDto orderDto = new OrderDto(1L, orderedProducts);
        return orderDto;
    }

    @DeleteMapping(value = "deleteOrder")
    public void deleteOrder(@RequestParam Long orderId) {
    }

    @PutMapping(value = "updateOrder")
    public OrderDto updateOrder(@RequestBody OrderDto orderDto) {

        List<ProductDto> orderedProducts = new ArrayList<>();
        orderDto.getOrderedProducts().add(new ProductDto(1L, "test product 3", "test description", new BigDecimal("15.99"), "3"));
        orderDto.getOrderedProducts().add(new ProductDto(2L, "test product 4", "test description", new BigDecimal("69.99"), "4"));
        OrderDto updatedOrderDto = new OrderDto(1L, orderedProducts);
        return updatedOrderDto;
    }

    @PostMapping(value = "createOrder")
    public void createOrder(@RequestBody OrderDto orderDto) {
    }
}