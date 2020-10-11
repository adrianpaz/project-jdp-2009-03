package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.*;
import com.kodilla.ecommercee.service.DbUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserMapper {

    @Autowired
    private DbUserService service;

    public User mapToUser(final UserDto userDto) {
        return new User(
                userDto.getUserName(),
                userDto.getUserKey(),
                userDto.getStatus(),
                service.findById(userDto.getId()).get().getOrderList(),
                service.findById(userDto.getId()).get().getCart());
    }

    public UserDto mapToUserDto(final User user) {
        return new UserDto(user.getId(), user.getUsername(), user.getStatus(), user.getUserKey());
    }

    public List<UserDto> mapToUserDtoList(final List<User> userList) {
        return userList.stream()
                .map(p -> mapToUserDto(p))
                .collect(Collectors.toList());
    }
}
