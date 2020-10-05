package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.Group;
import com.kodilla.ecommercee.domain.Product;
import com.kodilla.ecommercee.domain.ProductDto;
import com.kodilla.ecommercee.mapper.ProductMapper;
import com.kodilla.ecommercee.service.DbGroupService;
import com.kodilla.ecommercee.service.DbProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/ecommerce/product")
public class ProductController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);
    private final DbProductService productService;
    private final ProductMapper productMapper;
    private final DbGroupService groupService;

    @Autowired
    public ProductController(DbProductService productService, ProductMapper productMapper, DbGroupService groupService) {
        this.productService = productService;
        this.productMapper = productMapper;
        this.groupService = groupService;

    }

    @GetMapping(value = "getProducts")
    public List<ProductDto> getProducts() {
        return productMapper.mapToProductDtoList(productService.getAllProducts());
    }

    @GetMapping(value = "getProduct")
    public ProductDto getProduct(@RequestParam Long productId) throws ProductNotFoundException {
            return productMapper.mapToProductDto(productService.getProduct(productId));
    }

    @DeleteMapping(value = "deleteProduct")
    public void deleteProduct(@RequestParam Long productId) throws ProductNotFoundException {
        productService.deleteProduct(productId);
    }

    @PutMapping(value = "updateProduct")
    public ProductDto updateProduct(@RequestBody ProductDto productDto) throws ProductNotFoundException, GroupNotFoundException {
        return productMapper.mapToProductDto(productService.updateProduct(productDto));
    }

    @PostMapping(value = "createProduct")
    public void createProduct(@RequestBody ProductDto productDto) throws GroupNotFoundException {
        productService.createProduct(productDto);
    }
}
