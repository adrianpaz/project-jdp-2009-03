package com.kodilla.ecommercee.domain;

public class GroupDto {
    private Long Id;
    private String name;

    public GroupDto(Long id, String name) {
        Id = id;
        this.name = name;
    }

    public Long getId() {
        return Id;
    }

    public String getName() {
        return name;
    }
}
