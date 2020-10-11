package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.Cart;
import com.kodilla.ecommercee.domain.Item;
import com.kodilla.ecommercee.domain.ItemDto;
import com.kodilla.ecommercee.domain.Product;
import com.kodilla.ecommercee.service.DbCartService;
import com.kodilla.ecommercee.service.DbItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ItemMapper {
    @Autowired
    private DbItemService dbItemService;
    private DbCartService dbCartService;

    public Item mapToItem(Product product, ItemDto itemDto, Cart cart) {
        return new Item(product,
                itemDto.getQuantity(),
                cart);
    }

    public ItemDto mapToItemDto(final Item item) {
        return new ItemDto(
                item.getId(),
                item.getProduct().getId(),
                item.getQuantity());
    }

    public List<ItemDto> mapToItemDtoList(final List<Item> itemList) {
        return itemList.stream()
                .map(i -> new ItemDto(i.getId(), i.getProduct().getId(), i.getQuantity()))
                .collect(Collectors.toList());
    }
}
