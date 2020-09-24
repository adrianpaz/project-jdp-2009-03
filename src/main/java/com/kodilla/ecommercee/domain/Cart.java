package com.kodilla.ecommercee.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "CART")
public class Cart {
    private Long id;
    /*private User user;
    private List<Item> items = new ArrayList<>();*/

    public Cart() {
    }

    public Cart(Long id){
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Column(name = "ID", unique = true)
    public long getId() {
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

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "USER_ID")
    private User user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }*/
}
