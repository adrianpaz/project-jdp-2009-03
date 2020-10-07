package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.CartDto;
import com.kodilla.ecommercee.domain.UserDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/ecommercee/user")
public class UserController {


    @RequestMapping(method = RequestMethod.POST, value = "createUser")
    public UserDto createUser(@RequestBody UserDto userDto) {
        return userDto;
    }

    @RequestMapping(method = RequestMethod.PUT, value = "blockUser")
    public boolean blockUser(@RequestParam long userId) {
        System.out.println("User id: " + userId + " has been blocked");
        return true;
    }

    @RequestMapping(method = RequestMethod.GET, value = "createUserKey")
    public long createUserKey(@RequestParam long userId) {
        long userKey = 999999L;
        System.out.println("UserKey for User " + userId + " is: " + userKey);
        return userKey;
    }

}
