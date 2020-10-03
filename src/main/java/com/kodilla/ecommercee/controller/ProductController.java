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
    public ProductDto getProduct(@RequestParam Long productId) {
        try {
            return productMapper.mapToProductDto(productService.getProduct(productId).orElseThrow(ProductNotFoundException::new));
        } catch (Exception e) {
            LOGGER.error(e.toString());
            return null;
        }
    }

    @DeleteMapping(value = "deleteProduct")
    public void deleteProduct(@RequestParam Long productId) {
        try {
            Product productToDelete = productService.getProduct(productId).orElseThrow(ProductNotFoundException::new);
            Group group = productToDelete.getGroup();
            group.getProducts().remove(productToDelete);
            groupService.saveGroup(group);
        } catch (Exception e) {
            LOGGER.error(e.toString());
        }
    }

    @PutMapping(value = "updateProduct")
    public ProductDto updateProduct(@RequestBody ProductDto productDto) {
        try {
            productService.getProduct(productDto.getId()).orElseThrow(ProductNotFoundException::new);
            Group group = groupService.getGroup(Long.parseLong(productDto.getGroupId())).orElseThrow(GroupNotFoundException::new);
            return productMapper.mapToProductDto(productService.saveProduct(productMapper.mapToProduct(productDto, group)));
        } catch (Exception e) {
            LOGGER.error(e.toString());
            return null;
        }
    }

    @PostMapping(value = "createProduct")
    public void createProduct(@RequestBody ProductDto productDto) {
        try {
            Group group = groupService.getGroup(Long.parseLong(productDto.getGroupId())).orElseThrow(GroupNotFoundException::new);
            productService.saveProduct(productMapper.mapToProduct(productDto, group));
        } catch (Exception e) {
            LOGGER.error(e.toString());
        }
    }
}
