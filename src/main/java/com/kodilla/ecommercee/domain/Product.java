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
    //*do odkomentowania po implementacji encji Group, Cart i Order:
//    private Group group;
//    private List<Cart> cartList = new ArrayList<>();
//    private List<Order> orderList = new ArrayList<>();

    public Product() {
    }

    public Product(Long id, String name, String description, BigDecimal price//, Group group
        ) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
//        this.group = group;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Column(name = "ID", unique = true)
    public Long getId() {
        return id;
    }

    @Column(name = "NAME")
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

//    @ManyToOne
//    @JoinColumn(name = "GROUP_ID")
//    public Group getGroup() {
//        return group;
//    }
//
//    @ManyToMany(cascade = CascadeType.ALL)
//    @JoinTable(
//            name = "JOIN_PRODUCT_CART",
//            joinColumns = {@JoinColumn(name = "PRODUCT_ID", referencedColumnName = "ID")},
//            inverseJoinColumns = {@JoinColumn(name = "CART_ID", referencedColumnName = "ID")}
//    )
//    public List<Cart> getCartList() {
//        return cartList;
//    }

//    @ManyToMany(cascade = CascadeType.ALL)
//    @JoinTable(
//            name = "JOIN_PRODUCT_ORDER",
//            joinColumns = {@JoinColumn(name = "PRODUCT_ID", referencedColumnName = "ID")},
//            inverseJoinColumns = {@JoinColumn(name = "ORDER_ID", referencedColumnName = "ID")}
//    )
//    public List<Order> getOrderList() {
//        return orderList;
//    }

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

//    public void setGroup(Group group) {
//        this.group = group;
//    }
//
//    public void setCartList(List<Cart> cartList) {
//        this.cartList = cartList;
//    }
//
//    public void setOrderList(List<Order> orderList) {
//        this.orderList = orderList;
//    }
//    public void addCart(Cart cart){
//        this.cartList.add(cart);
//    }
//
//    public void addOrder(Order order){
//        this.orderList.add(order);
//    }
}
