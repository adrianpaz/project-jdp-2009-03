package com.kodilla.ecommercee.domain.user;

import lombok.Getter;
import lombok.AllArgsConstructor;

@Getter
@AllArgsConstructor
public class UserDto {

    private Long id;
    private String userName;
    private boolean status;
    private Long userKey;

}
