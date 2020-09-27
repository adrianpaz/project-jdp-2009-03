package com.kodilla.ecommercee;

import com.kodilla.ecommercee.domain.Group;
import com.kodilla.ecommercee.domain.Product;
import com.kodilla.ecommercee.repository.ProductRepository;
import com.kodilla.ecommercee.service.DbGroupService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EcommerceGroupTest {

    @Autowired
    private DbGroupService service;

    @Autowired
    private ProductRepository productRepository;

    @Test
    public void testGetGroups() {
        //Given
        Group group1 = new Group("Ubrania");
        Group group2 = new Group("Dodatki");
        Group group3 = new Group("Biżuteria");
        Group group4 = new Group("Obuwie");
        service.saveGroup(group1);
        service.saveGroup(group2);
        service.saveGroup(group3);
        service.saveGroup(group4);

        //When
        List<Group> groups = service.getAllGropus();

        //Then
        long idGroup1 = group1.getId();
        long idGroup2 = group2.getId();
        long idGroup3 = group3.getId();
        long idGroup4 = group4.getId();
        assertEquals(4, groups.size());

        //CleanUp
        service.deleteGroup(idGroup1);
        service.deleteGroup(idGroup2);
        service.deleteGroup(idGroup3);
        service.deleteGroup(idGroup4);
    }

    @Test
    public void testGetProductsFromGroup() {
        //Given
        Group group1 = new Group("Ubrania");

        //When
        service.saveGroup(group1);
        long idGroup1 = group1.getId();
        Product product1 = new Product("Koszula", "Bawełniana rozmiar M",
                new BigDecimal("65.99"), group1);
        Product product2 = new Product("Spodnie", "Levi's",
                new BigDecimal("65.99"), group1);
        Product product3 = new Product("Krawat", "Prążkowany",
                new BigDecimal("65.99"), group1);
        Product product4 = new Product("Skarpetki", "Rozmiar 43",
                new BigDecimal("65.99"), group1);
        productRepository.save(product1);
        long idProduct1 = product1.getId();
        productRepository.save(product2);
        long idProduct2 = product2.getId();
        productRepository.save(product3);
        long idProduct3 = product3.getId();
        productRepository.save(product4);
        long idProduct4 = product4.getId();

        //Then
        List<Product> products = Optional.ofNullable(service.getGroup(idGroup1).get().getProducts()).
                orElse(new ArrayList<>());
        assertEquals(4, products.size());

        //CleanUp
        productRepository.deleteById(idProduct1);
        productRepository.deleteById(idProduct2);
        productRepository.deleteById(idProduct3);
        productRepository.deleteById(idProduct4);
        service.deleteGroup(idGroup1);
    }

    @Test
    public void testDeleteGroup() {
        //Given
        Group group1 = new Group("Ubrania");
        Group group2 = new Group("Dodatki");
        Group group3 = new Group("Biżuteria");
        Group group4 = new Group("Obuwie");
        service.saveGroup(group1);
        service.saveGroup(group2);
        service.saveGroup(group3);
        service.saveGroup(group4);
        long idGroup1 = group1.getId();
        long idGroup2 = group2.getId();
        long idGroup3 = group3.getId();
        long idGroup4 = group4.getId();

        //When
        service.deleteGroup(idGroup1);

        //Then
        List<Group> groups = service.getAllGropus();
        assertEquals(3, groups.size());

        //CleanUp
        service.deleteGroup(idGroup2);
        service.deleteGroup(idGroup3);
        service.deleteGroup(idGroup4);
    }

    @Test
    public void testUpdateGroup() {
        //Given
        Group group1 = new Group("Ubrania");
        Group group2 = new Group("Dodatki");
        Group group3 = new Group("Biżuteria");
        Group group4 = new Group("Obuwie");
        service.saveGroup(group1);
        service.saveGroup(group2);
        service.saveGroup(group3);
        service.saveGroup(group4);
        long idGroup1 = group1.getId();
        long idGroup2 = group2.getId();
        long idGroup3 = group3.getId();
        long idGroup4 = group4.getId();

        //When
        Group group5 = new Group("Zegarki");
        group5.setId(idGroup1);
        service.saveGroup(group5);
        //Then
        Optional<Group> group = service.getGroup(idGroup1);
        String groupName = group.get().getName();
        assertEquals("Zegarki", groupName);

        //CleanUp
        service.deleteGroup(idGroup1);
        service.deleteGroup(idGroup2);
        service.deleteGroup(idGroup3);
        service.deleteGroup(idGroup4);
    }
}
