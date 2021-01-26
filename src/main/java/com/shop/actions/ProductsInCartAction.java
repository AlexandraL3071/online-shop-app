package com.shop.actions;

import com.opensymphony.xwork2.ActionSupport;
import com.shop.model.CartProduct;
import com.shop.service.CartService;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
public class ProductsInCartAction extends ActionSupport implements SessionAware {

    private List<CartProduct> products = new ArrayList<>();
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

        if (username.equals("anonymous")) {
            return "anonymous";
        }

        return "loggedUser";
    }

    public List<CartProduct> getProducts() {
        return products;
    }

    public void setProducts(List<CartProduct> products) {
        this.products = products;
    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }
}
