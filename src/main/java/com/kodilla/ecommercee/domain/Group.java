package com.kodilla.ecommercee.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "GROUPS")
public final class Group {
    private long id;
    private String name;
//    private List<Product> products = new ArrayList<>();

    public Group() {
    }

    public Group(String name) {
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Column(name = "ID", unique = true)
    public long getId() {
        return id;
    }

    @Column(name = "GROUP_NAME", unique = true)
    public String getName() {
        return name;
    }

//    @OneToMany (
//            targetEntity = Product.class,
//            mappedBy = "group",
//            cascade = CascadeType.ALL,
//            fetch = FetchType.LAZY
//    )
//    public List<Product> getProducts() {
//        return products;
//    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

//
}


