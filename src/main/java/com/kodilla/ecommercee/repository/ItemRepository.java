package com.kodilla.ecommercee.repository;

import com.kodilla.ecommercee.domain.Item;
import org.springframework.data.repository.CrudRepository;

public interface ItemRepository extends CrudRepository<Item, Long> {
}
