package com.shop.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Entity
public class CustomOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private Date orderDate;

    @ManyToOne
    @JoinColumn
    private User user;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "customOrder")
    private Collection<OrderProduct> orderProducts;

    private Double totalPrice;

    private String deliveryAddress;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public Collection<OrderProduct> getOrderProducts() {
        return orderProducts;
    }

    public void setOrderProducts(Collection<OrderProduct> orderProducts) {
        this.orderProducts = orderProducts;
    }
}
