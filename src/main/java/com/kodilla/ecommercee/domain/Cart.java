package com.kodilla.ecommercee.domain;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "CARTS")
public class Cart {
    private Long id;
    private List<Item> items = new ArrayList<>();

    public Cart(List<Item> items) {
        this.items = items;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Column(name = "ID", unique = true)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @OneToMany(
            targetEntity = Item.class,
            mappedBy = "cart",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}