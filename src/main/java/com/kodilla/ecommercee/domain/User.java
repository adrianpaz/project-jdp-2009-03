package com.kodilla.ecommercee.domain;


import javax.persistence.*;
import javax.persistence.criteria.Order;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "USERS")
public class User {

    private Long Id;
    private String username;
    private int usersKey;
//    private List<Order> orderList = new ArrayList<>();
//    private Cart cart;

    public User() {
    }

    public User(String username, int usersKey) {
        this.username = username;
        this.usersKey = usersKey;
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
    public int getUsersKey() {
        return usersKey;
    }

//    @OneToMany
//            (targetEntity = Order.class,
//            mappedBy = "orderList",
//            cascade = CascadeType.ALL,
//            fetch = FetchType.EAGER
//            )
//    public List<Order> getOrderList() {
//        return orderList;
//    }

//    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    @JoinColumn(name = "USER_CART_ID")
//    public Cart getCart() {
//        return cart;
//    }

    public void setId(Long id) {
        Id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setUsersKey(int usersKey) {
        this.usersKey = usersKey;
    }

//    public void setOrderList(List<Order> orderList) {
//        this.orderList = orderList;
//    }

//    public void setCart(Cart cart) {
//        this.cart = cart;
//    }
}