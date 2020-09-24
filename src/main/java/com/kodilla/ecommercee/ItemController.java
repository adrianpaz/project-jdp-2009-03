package com.kodilla.ecommercee;

import com.kodilla.ecommercee.domain.ItemDto;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/ecommerce/item")
public class ItemController {

    @RequestMapping(method = RequestMethod.GET, value = "getItems")
    public List<ItemDto> getItems() {
        List<ItemDto> retrievedItems = new ArrayList<>();
        retrievedItems.add(new ItemDto(1L,1L,5));
        retrievedItems.add(new ItemDto(2L,3L,12));
        return retrievedItems;
    }

    @RequestMapping(method = RequestMethod.GET, value = "getItem")
    public ItemDto getItem(@RequestParam Long itemId) {
        return new ItemDto(1L, 1L, 6);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteItem")
    public void deleteItem(@RequestParam Long itemId) {

    }

    @RequestMapping(method = RequestMethod.PUT, value = "updateItem")
    public ItemDto updateItem(@RequestBody ItemDto itemDto) {
        return new ItemDto(1L, 2L, 9);
    }

    @RequestMapping(method = RequestMethod.POST, value = "createItem")
    public void createItem(@RequestBody ItemDto itemDto) {
    }
}
