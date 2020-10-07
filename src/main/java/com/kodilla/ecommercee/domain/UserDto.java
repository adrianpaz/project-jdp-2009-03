package com.kodilla.ecommercee.domain;

public class UserDto {

    private Long id;
    private String userName;
    private String status;
    private Long userKey;

    public UserDto(Long id, String userName, String status, Long userKey) {
        this.id = id;
        this.userName = userName;
        this.status = status;
        this.userKey = userKey;
    }

    public Long getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public String getStatus() {
        return status;
    }

    public Long getUserKey() {
        return userKey;
    }
}