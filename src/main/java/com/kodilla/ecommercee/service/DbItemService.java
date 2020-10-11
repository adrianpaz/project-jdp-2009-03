package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.controller.CartNotFoundException;
import com.kodilla.ecommercee.controller.ItemNotFoundException;
import com.kodilla.ecommercee.controller.ProductNotFoundException;
import com.kodilla.ecommercee.domain.Cart;
import com.kodilla.ecommercee.domain.Item;
import com.kodilla.ecommercee.domain.ItemDto;
import com.kodilla.ecommercee.domain.Product;
import com.kodilla.ecommercee.mapper.ItemMapper;
import com.kodilla.ecommercee.repository.CartRepository;
import com.kodilla.ecommercee.repository.ItemRepository;
import com.kodilla.ecommercee.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DbItemService {
    private final ItemRepository itemRepository;
    private final DbCartService dbCartService;
    private final ItemMapper itemMapper;
    private final ProductRepository productRepository;
    private final CartRepository cartRepository;

    @Autowired
    public DbItemService(ItemRepository itemRepository, DbCartService dbCartService, ItemMapper itemMapper,
                         ProductRepository productRepository, CartRepository cartRepository) {
        this.itemRepository = itemRepository;
        this.dbCartService = dbCartService;
        this.itemMapper = itemMapper;
        this.productRepository = productRepository;
        this.cartRepository = cartRepository;
    }

    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    public Item getItem(final Long itemId) throws ItemNotFoundException {
        return itemRepository.findById(itemId).orElseThrow(ItemNotFoundException::new);
    }

    public void deleteItem(Long itemId) throws ItemNotFoundException {
        Item itemToDelete = itemRepository.findById(itemId).orElseThrow(ItemNotFoundException::new);
        Cart cart = itemToDelete.getCart();
        cart.getItems().remove(itemToDelete);
        dbCartService.saveCart(cart);
    }

    private ItemDto updateItem(final ItemDto itemDto) throws ItemNotFoundException, ProductNotFoundException,
            CartNotFoundException {
        Product product = productRepository.findById(itemDto.getProductId()).orElseThrow(ProductNotFoundException::new);
        Cart cart = cartRepository.findById(itemDto.getId()).orElseThrow(CartNotFoundException::new);
        Item item = itemMapper.mapToItem(product, itemDto, cart);

        try {
            Item itemToUpdate = itemRepository.findById(itemDto.getId()).orElseThrow(ItemNotFoundException::new);
            itemToUpdate.setProduct(product);
            itemToUpdate.setCart(cart);
            itemToUpdate.setQuantity(itemDto.getQuantity());
            itemRepository.save(itemToUpdate);
        } catch (Exception e) {
            throw new ItemNotFoundException();
        }
        return itemDto;

    }

    public void createItem(final ItemDto itemDto) throws ItemNotFoundException, ProductNotFoundException,
            CartNotFoundException {
        Product product = productRepository.findById(itemDto.getProductId()).orElseThrow(ProductNotFoundException::new);
        Cart cart = cartRepository.findById(itemDto.getId()).orElseThrow(CartNotFoundException::new);
        itemRepository.save(new Item(product, itemDto.getQuantity(), cart));
    }
}
