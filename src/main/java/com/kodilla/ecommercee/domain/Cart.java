package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "CARTS")
public class Cart {
    private Long id;
    //private List<Item> items = new ArrayList<>();

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

    /*@OneToMany (
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
    }*/
}
