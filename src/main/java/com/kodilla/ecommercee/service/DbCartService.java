package com.kodilla.ecommercee.service;

import ch.qos.logback.classic.Logger;
import com.kodilla.ecommercee.controller.CartNotFoundException;
import com.kodilla.ecommercee.controller.GroupNotFoundException;
import com.kodilla.ecommercee.domain.*;
import com.kodilla.ecommercee.mapper.ProductMapper;
import com.kodilla.ecommercee.repository.CartRepository;
import com.kodilla.ecommercee.repository.OrderRepository;
import com.kodilla.ecommercee.repository.ProductRepository;
import com.kodilla.ecommercee.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DbCartService {
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private DbCartService dbCartService;
    @Autowired
    private DbProductService productService;

    public Cart saveCart(final Cart cart) {
        return cartRepository.save(cart);
    }

    public Optional<Cart> getCart(final Long cartId) {
        return cartRepository.findById(cartId);
    }

    public void deleteCart(final Long id) {
        cartRepository.deleteById(id);
    }

    public Order createOrder(final Long cartId) {
        return orderRepository.save(new Order());
    }

    public List<Cart> getAllCards() {
        return cartRepository.findAll();
    }
}
