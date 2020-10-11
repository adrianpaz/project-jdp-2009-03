package com.kodilla.ecommercee.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "ORDERS")
public class Order {

    private Long id;
    private Long userId;
    public List<ProductDto> orderedProducts;


    public Order(Long id, Long userId, List<ProductDto> orderedProducts) {
        this.id = id;
        this.userId = userId;
        this.orderedProducts = orderedProducts;
    }

    public Order() {
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
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    @JoinColumn(name = "orderedItems")
    public List<Item> orderedItems;

    @JoinColumn(name = "userId")
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;

}
