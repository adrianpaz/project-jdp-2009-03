package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.CartDto;
import com.kodilla.ecommercee.domain.UserDto;
import com.kodilla.ecommercee.mapper.UserMapper;
import com.kodilla.ecommercee.service.DbUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

@RestController
@RequestMapping("/v1/ecommerce/user")
public class UserController {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private DbUserService service;

    @RequestMapping(method = RequestMethod.POST, value = "createUser")
    public void createUser(@RequestBody UserDto userDto) {
        service.saveUser(userMapper.mapToUser(userDto));
    }

    @RequestMapping(method = RequestMethod.PUT, value = "blockUser")
    public boolean blockUser(@RequestParam long userId) throws UserNotFoundException{
        service.findById(userId).orElseThrow(UserNotFoundException::new);
        System.out.println("User id: " + userId + " has been blocked");
        return true;
    }

    @RequestMapping(method = RequestMethod.GET, value = "createUserKey")
    public long createUserKey(@RequestParam long userId) throws UserNotFoundException {
        Random random = new Random();
        long longUserKey = random.nextLong();
        service.findById(userId).ifPresent(user -> user.setUserKey(longUserKey));
        System.out.println("UserKey for User " + userId + " is: " + longUserKey);
        return longUserKey;
    }
}
