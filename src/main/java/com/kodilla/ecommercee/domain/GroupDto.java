package com.kodilla.ecommercee.domain;

import java.util.ArrayList;
import java.util.List;

public class GroupDto {
    private Long id;
    private String name;

    public GroupDto(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
