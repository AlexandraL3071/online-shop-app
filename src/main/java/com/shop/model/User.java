package com.shop.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String username;

    private String password;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "user")
    private Collection<CustomOrder> customOrders;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "user")
    private Collection<CartProduct> cartProducts;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Collection<CustomOrder> getCustomOrders() {
        return customOrders;
    }

    public void setCustomOrders(Collection<CustomOrder> customOrders) {
        this.customOrders = customOrders;
    }

    public Collection<CartProduct> getCartProducts() {
        return cartProducts;
    }

    public void setCartProducts(Collection<CartProduct> cartProducts) {
        this.cartProducts = cartProducts;
    }
}
