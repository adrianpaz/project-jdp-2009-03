package com.kodilla.ecommercee.domain.user;

import lombok.Getter;
import lombok.AllArgsConstructor;

@Getter
@AllArgsConstructor
public class UserDto {

    private Long id;
    private String userName;
    private String status;
    private Long userKey;

}
