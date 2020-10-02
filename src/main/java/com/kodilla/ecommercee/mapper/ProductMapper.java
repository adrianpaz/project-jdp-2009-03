package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.controller.GroupNotFoundException;
import com.kodilla.ecommercee.domain.Group;
import com.kodilla.ecommercee.domain.GroupDto;
import com.kodilla.ecommercee.domain.Product;
import com.kodilla.ecommercee.domain.ProductDto;
import com.kodilla.ecommercee.service.DbGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductMapper {
    @Autowired
    private DbGroupService service;

    public Product mapToProduct(final ProductDto productDto) throws GroupNotFoundException {
        Group group = service.getGroup(Long.parseLong(productDto.getGroupId())).orElseThrow(GroupNotFoundException::new);
        return new Product(
                productDto.getName(),
                productDto.getDescription(),
                productDto.getPrice(),
                group);
    }

    public ProductDto mapToProductDto(final Product product) {
        return new ProductDto(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getGroup().getId().toString());
    }

    public List<ProductDto> mapToProductDtoList(final List<Product> productList) {
        return productList.stream()
                .map(p -> mapToProductDto(p))
                .collect(Collectors.toList());
    }
}
