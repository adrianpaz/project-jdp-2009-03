package com.kodilla.ecommercee.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "PRODUCTS")
public class Product {
    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    private Group group;

    public Product() {
    }

    public Product(Long id, String name, String description, BigDecimal price, Group group) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.group = group;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Column(name = "ID", unique = true)
    public Long getId() {
        return id;
    }

    @Column(name = "NAME", unique = true)
    public String getName() {
        return name;
    }

    @Column(name = "DESCRIPION")
    public String getDescription() {
        return description;
    }

    @Column(name = "PRICE")
    public BigDecimal getPrice() {
        return price;
    }

    @ManyToOne
    @JoinColumn(name = "GROUP_ID")
    public Group getGroup() {
        return group;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setGroup(Group group) {
        this.group = group;
    }
}
