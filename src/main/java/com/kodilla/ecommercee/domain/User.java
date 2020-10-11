package com.kodilla.ecommercee.domain;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "USERS")
public class User {

    private Long Id;
    private String username;
    private Long userKey;
    private String status;
    private List<Order> orderList;
    private Cart cart;

    public User() {
    }

    public User(String username, Long userKey, String status, List<Order> orderList, Cart cart) {
        this.username = username;
        this.userKey = userKey;
        this.status = status;
        this.orderList = orderList;
        this.cart = cart;
    }

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column (name = "USER_ID")
    public Long getId() {
        return Id;
    }

    @Column(name = "USERNAME")
    public String getUsername() {
        return username;
    }


    @Column(name = "USERS_KEY")
    public Long getUserKey() {
        return userKey;
    }

    @Column(name = "USERS_STATUS")
    public String getStatus() {
        return status;
    }

    @OneToMany
            (targetEntity = Order.class,
            mappedBy = "id",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
            )
    public List<Order> getOrderList() {
        return orderList;
    }

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "USER_CART_ID")
    public Cart getCart() {
        return cart;
    }

    public void setId(Long id) {
        Id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setUserKey(Long usersKey) {
        this.userKey = usersKey;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }
}