package com.shop.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class OrderProduct {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private int selectedQuantity;

    @NotNull
    @ManyToOne
    @JoinColumn
    private Order order;

    @NotNull
    @ManyToOne
    @JoinColumn
    private Product product;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSelectedQuantity() {
        return selectedQuantity;
    }

    public void setSelectedQuantity(int selectedQuantity) {
        this.selectedQuantity = selectedQuantity;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
