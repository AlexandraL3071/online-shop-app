package com.shop.actions;

import com.opensymphony.xwork2.ActionSupport;
import com.shop.model.Product;
import com.shop.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.*;
public class ProductsInCartAction extends ActionSupport {

    private List<Product> products = new ArrayList<>();

    private String username;

    @Autowired
    private CartService cartService;

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String execute() {
        products = cartService.findProductsByUserName(username);
        return "success";
    }
}
