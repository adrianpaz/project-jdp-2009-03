package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.ItemDto;
import com.kodilla.ecommercee.mapper.ItemMapper;
import com.kodilla.ecommercee.service.DbItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/ecommerce/item")
public class ItemController {
    @Autowired
    private ItemMapper itemMapper;
    @Autowired
    private DbItemService dbItemService;


    @GetMapping(value = "getItem")
    public ItemDto getItem(@RequestParam Long itemId) throws ItemNotFoundException {
        return itemMapper.mapToItemDto(dbItemService.getItem(itemId));
    }

    @PostMapping(value = "createItem")
    public void createItem(@RequestBody ItemDto itemDto) throws ProductNotFoundException,
            CartNotFoundException, ItemNotFoundException {
        dbItemService.createItem(itemDto);
    }

    @DeleteMapping(value = "deleteItem")
    public void deleteItem(@RequestParam Long itemId) throws ItemNotFoundException {
        dbItemService.deleteItem(itemId);
    }
}
