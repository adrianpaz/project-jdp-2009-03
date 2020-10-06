package com.kodilla.ecommercee;

import com.kodilla.ecommercee.domain.Cart;
import com.kodilla.ecommercee.domain.Group;
import com.kodilla.ecommercee.domain.Item;
import com.kodilla.ecommercee.domain.Product;
import com.kodilla.ecommercee.repository.CartRepository;
import com.kodilla.ecommercee.repository.GroupRepository;
import com.kodilla.ecommercee.repository.ItemRepository;
import com.kodilla.ecommercee.repository.ProductRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Transactional
@RunWith(SpringRunner.class)
@SpringBootTest
public class CartTestSuite {
    @Autowired
    GroupRepository groupRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    ItemRepository itemRepository;
    @Autowired
    CartRepository cartRepository;

    @Test
    public void testFindCartById(){

        //Given
        Group testGroup1 = new Group("Test group");
        groupRepository.save(testGroup1);
        Long testGroup1Id = testGroup1.getId();

        Product testProduct1 = new Product("Dress", "cotton", new BigDecimal(250), testGroup1);
        Product testProduct2 = new Product("T-shirt", "cotton", new BigDecimal(50), testGroup1);
        productRepository.save(testProduct1);
        productRepository.save(testProduct2);
        Long testProduct1Id = testProduct1.getId();
        Long testProduct2Id = testProduct2.getId();

        List<Item> itemsFromCart = new ArrayList<>();
        Cart cart = new Cart(itemsFromCart);

        //When
        cartRepository.save(cart);
        Long idCart = cart.getId();

        Item item1 = new Item(testProduct1, 3, cart);
        Item item2 = new Item(testProduct2, 2, cart);
        itemRepository.save(item1);
        itemRepository.save(item2);
        Long item1Id = item1.getId();
        Long item2Id = item2.getId();
        cart.getItems().add(item1);
        cart.getItems().add(item2);
        cartRepository.save(cart);

        //Then
        Assert.assertEquals(2,cartRepository.findById(idCart).get().getItems().size());

        //CleanUp
        itemRepository.deleteById(item1Id);
        itemRepository.deleteById(item2Id);
        cartRepository.deleteById(idCart);
        productRepository.deleteById(testProduct1Id);
        productRepository.deleteById(testProduct2Id);
        groupRepository.deleteById(testGroup1Id);
    }

    @Test
    public void testDeleteCart(){

        //Given
        List<Item> itemsFromCart = new ArrayList<>();
        Cart cart1 = new Cart(itemsFromCart);
        Cart cart2 = new Cart(itemsFromCart);
        Cart cart3 = new Cart(itemsFromCart);
        cartRepository.save(cart1);
        cartRepository.save(cart2);
        cartRepository.save(cart3);
        Long cart1Id = cart1.getId();
        Long cart2Id = cart2.getId();
        Long cart3Id = cart3.getId();

        //When
        cartRepository.deleteById(cart1Id);

        //Then
        Assert.assertEquals(2,cartRepository.findAll().size());

        //CleanUp
        cartRepository.deleteById(cart2Id);
        cartRepository.deleteById(cart3Id);
    }
}
