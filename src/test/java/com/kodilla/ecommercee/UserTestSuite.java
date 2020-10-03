package com.kodilla.ecommercee;

import com.kodilla.ecommercee.domain.User;
import com.kodilla.ecommercee.repository.UserRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTestSuite {
    @Autowired
    private UserRepository userRepository;

    @Test
    public void testFindAllUsers(){
        //Given
        User user1 = new User("Adam Kowalski", 1234);
        User user2 = new User("Joanna Smith", 1784);
        User user3 = new User("Marian Dzik", 2934);

        //When
        userRepository.save(user1);
        userRepository.save(user2);
        userRepository.save(user3);
        List<User> userList = userRepository.findAll();

        //Then
        Assert.assertEquals(3, userList.size());

        //CleanUp
        userRepository.delete(user1);
        userRepository.delete(user2);
        userRepository.delete(user3);
    }

    @Test
    public void testDeleteUser(){
        //Given
        User user1 = new User("Adam Kowalski", 1234);
        User user2 = new User("Joanna Smith", 1784);
        User user3 = new User("Marian Dzik", 2934);

        //When
        userRepository.save(user1);
        userRepository.save(user2);
        userRepository.save(user3);
        userRepository.delete(user1);
        List<User> userList = userRepository.findAll();

        //Then
        System.out.println(userList);
        Assert.assertEquals(2, userList.size());

        //CleanUp
        userRepository.delete(user2);
        userRepository.delete(user3);
    }

    @Test
    public void testFindById(){
        //Given
        User user1 = new User("Adam Kowalski", 1234);

        //When
        userRepository.save(user1);
        Optional<User> userId = userRepository.findById(user1.getId());

        //Then
        System.out.println(userId);
        Assert.assertTrue(userId.isPresent());

        //CleanUp
        userRepository.delete(user1);
    }
}
