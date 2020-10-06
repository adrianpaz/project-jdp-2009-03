package com.kodilla.ecommercee.repository;

import com.kodilla.ecommercee.domain.Order;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface OrderRepository extends CrudRepository<Order, Long> {

    @Override
    <S extends Order> S save(S entity);

    @Override
    Optional<Order> findById(Long id);

    @Override
    Iterable<Order> findAll();

}
