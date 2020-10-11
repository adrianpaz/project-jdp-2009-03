package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.domain.Order;
import com.kodilla.ecommercee.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;


public class DbOrderService {

    @Autowired
    private OrderRepository orderRepository;


    public <S extends Order> S save(S entity) {
        return orderRepository.save(entity);
    }

    public Optional<Order> findById(Long id) {
        return orderRepository.findById(id);
    }

    public Iterable<Order> findAll() {
        return orderRepository.findAll();
    }

    public void deleteById(Long id) {
        orderRepository.deleteById(id);
    }

    public void deleteAll() {
        orderRepository.deleteAll();
    }

}
