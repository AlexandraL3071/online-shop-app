package com.shop.actions;

import com.opensymphony.xwork2.ActionSupport;
import com.shop.model.Product;
import com.shop.service.CartService;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.*;
public class ProductsInCartAction extends ActionSupport implements SessionAware {

    private List<Product> products = new ArrayList<>();
    private Map<String, Object> session;

    @Autowired
    private CartService cartService;

    @Override
    public String execute() {
        String username;

        if (session.get("loggedUser") != null) {
            username = (String) session.get("loggedUser");
        } else {
            username = "anonymous";
        }

        products = cartService.findProductsByUsername(username);
        return "success";
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }
}
