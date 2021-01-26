package com.shop.actions;

import com.opensymphony.xwork2.ActionSupport;
import com.shop.model.CartProduct;
import com.shop.service.CartService;
import com.shop.service.PlaceOrderService;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public class PlaceOrderAction extends ActionSupport implements SessionAware {
    private String deliveryAddress;
    private String username;
    private String date;

    private Double totalPrice;

    private List<CartProduct> products;

    private Map<String, Object> session;

    @Autowired
    private PlaceOrderService placeOrderService;

    @Autowired
    private CartService cartService;

    @Override
    public String execute() {
        if (session.get("loggedUser") != null) {
            this.username = (String) session.get("loggedUser");
        } else {
            this.username = "anonymous";
        }

        this.products = cartService.findProductsByUsername(username);
        this.totalPrice = placeOrderService.getTotalPrice(products);
        LocalDateTime today = LocalDateTime.now();
        this.date = today.toString();

        if (username.equals("anonymous")) {
            return "anonymous";
        }

        return "loggedUser";
    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public List<CartProduct> getProducts() {
        return products;
    }

    public void setProducts(List<CartProduct> products) {
        this.products = products;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}

