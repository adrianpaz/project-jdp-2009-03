package com.kodilla.ecommercee;

import com.kodilla.ecommercee.domain.Group;
import com.kodilla.ecommercee.domain.Product;
import com.kodilla.ecommercee.repository.GroupRepository;
import com.kodilla.ecommercee.repository.ProductRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.sql.SQLOutput;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductTestSuite {
    @Autowired
    ProductRepository productRepository;

    @Autowired
    GroupRepository groupRepository;

    @Test
    public void testFindProductById(){
        //Given
        Group group = new Group("Test Group");
        groupRepository.save(group);
        Long groupId = group.getId();

        Product product = new Product("Test product1", "Test description1", new BigDecimal("100"), group);
        group.getProducts().add(product);
        productRepository.save(product);
        Long productId = product.getId();

        //When
        Optional<Product> retrievedProduct = productRepository.findById(productId);

        //Then
        Assert.assertTrue(retrievedProduct.isPresent());

        //CleanUp
        try{
            groupRepository.deleteById(groupId);
        }catch (Exception e) {
            //do nothing
        }
    }

    @Test
    public void testFindAllProducts(){
        //Given
        Group group1 = new Group("Test Group1");
        groupRepository.save(group1);
        Long group1Id = group1.getId();

        Product product1 = new Product("Test product1", "Test description1", new BigDecimal("100"), group1);
        Product product2 = new Product("Test product2", "Test description2", new BigDecimal("200"), group1);
        group1.getProducts().add(product1);
        group1.getProducts().add(product2);

        Group group2 = new Group("Test Group2");
        groupRepository.save(group2);
        Long group2Id = group2.getId();

        Product product3 = new Product("Test product3", "Test description3", new BigDecimal("300"), group2);
        group2.getProducts().add(product3);

        productRepository.save(product1);
        productRepository.save(product2);
        productRepository.save(product3);

        //When
        List<Product> retrievedProducts = productRepository.findAll();

        //Then
        Assert.assertEquals(3, retrievedProducts.size());

        //CleanUp
        try{
            groupRepository.deleteById(group1Id);
            groupRepository.deleteById(group2Id);
        }catch (Exception e) {
            //do nothing
        }
    }

    @Test
    public void testGetProductsFromGroupAfterSavingProducts(){
        //Given
        Group group = new Group("Test Group");
        groupRepository.save(group);
        Long groupId = group.getId();

        Product product1 = new Product("Test product1", "Test description1", new BigDecimal("100"), group);
        Product product2 = new Product("Test product2", "Test description2", new BigDecimal("200"), group);
        group.getProducts().add(product1);
        group.getProducts().add(product2);

        //When
        productRepository.save(product1);
        productRepository.save(product2);
        Group retrievedGroup = groupRepository.findById(groupId).orElse(new Group("test"));
        List<Product> productsFromRetrievedGroup = retrievedGroup.getProducts();

        //Then
        Assert.assertEquals(2, productsFromRetrievedGroup.size());

        //CleanUp
        try{
            groupRepository.deleteById(groupId);
        }catch (Exception e) {
            //do nothing
        }
    }

    @Test
    public void testDeleteProduct(){
        //Given
        Group group = new Group("Test Group");
        groupRepository.save(group);
        Long groupId = group.getId();

        System.out.println(productRepository.findAll().size());

        Product product = new Product("Test product1", "Test description1", new BigDecimal("100"), group);
        group.getProducts().add(product);
        productRepository.save(product);
        Long productId = product.getId();

        //When
        productRepository.deleteById(productId);

        //Then
        System.out.println(productRepository.findAll().size());

        //CleanUp
        try{
            groupRepository.deleteById(groupId);
            System.out.println(productRepository.findAll().size());
        }catch (Exception e) {
            //do nothing
        }
    }
}


