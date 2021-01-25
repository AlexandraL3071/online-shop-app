package com.shop.model;

import javax.persistence.*;

@Entity
public class OrderProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private int selectedQuantity;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn
    private CustomOrder customOrder;

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

    public CustomOrder getCustomOrder() {
        return customOrder;
    }

    public void setCustomOrder(CustomOrder customOrder) {
        this.customOrder = customOrder;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
