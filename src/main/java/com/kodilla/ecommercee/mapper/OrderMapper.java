package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.Item;
import com.kodilla.ecommercee.domain.Order;
import com.kodilla.ecommercee.domain.OrderDto;

import java.util.List;
import java.util.stream.Collectors;

public class OrderMapper {


    public OrderDto mapToOrderDto(final Order order) {
        return new OrderDto(
                order.getId(),
                order.getUserId(),
                order.orderedProducts);
    }

    public Order mapToOrder(final OrderDto orderDto){
        return new Order(
                orderDto.getId(),
                orderDto.getUserId(),
                orderDto.getOrderedProducts());
    }


    public List<OrderDto> mapToOrderDtoList(final List<Order> ordersList) {
        return ordersList
                .stream()
                .map(o -> new OrderDto(o.getId(), o.getUserId(), o.orderedProducts))
                .collect(Collectors.toList());
    }
}
