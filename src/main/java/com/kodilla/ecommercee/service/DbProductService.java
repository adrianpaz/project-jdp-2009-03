package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.controller.GroupNotFoundException;
import com.kodilla.ecommercee.controller.ProductNotFoundException;
import com.kodilla.ecommercee.domain.Group;
import com.kodilla.ecommercee.domain.Product;
import com.kodilla.ecommercee.domain.ProductDto;
import com.kodilla.ecommercee.mapper.ProductMapper;
import com.kodilla.ecommercee.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class DbProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    private final DbGroupService groupService;

    @Autowired
    public DbProductService(ProductRepository repository, ProductMapper productMapper, DbGroupService groupService) {
        this.productRepository = repository;
        this.productMapper = productMapper;
        this.groupService = groupService;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProduct(final Long productId) throws ProductNotFoundException {
        return productRepository.findById(productId).orElseThrow(ProductNotFoundException::new);
    }

    public void deleteProduct(Long productId) throws ProductNotFoundException{
        Product productToDelete = productRepository.findById(productId).orElseThrow(ProductNotFoundException::new);
        Group group = productToDelete.getGroup();
        group.getProducts().remove(productToDelete);
        groupService.saveGroup(group);
    }

    public Product updateProduct(final ProductDto productDto) throws ProductNotFoundException, GroupNotFoundException {
        productRepository.findById(productDto.getId()).orElseThrow(ProductNotFoundException::new);
        Group group = groupService.getGroup(Long.parseLong(productDto.getGroupId())).orElseThrow(GroupNotFoundException::new);
        return productRepository.save(productMapper.mapToProduct(productDto, group));
    }

    public void createProduct(final ProductDto productDto) throws GroupNotFoundException{
        Group group = groupService.getGroup(Long.parseLong(productDto.getGroupId())).orElseThrow(GroupNotFoundException::new);
        productRepository.save(productMapper.mapToProduct(productDto, group));
    }
}
