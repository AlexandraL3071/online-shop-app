package com.shop.actions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.shop.dao.UserDAO;
import com.shop.model.CartProduct;
import com.shop.model.CustomOrder;
import com.shop.model.OrderProduct;
import com.shop.model.User;
import com.shop.service.CartService;
import com.shop.service.PlaceOrderService;
import com.shop.service.UserService;
import javassist.tools.reflect.Sample;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import java.util.*;

public class SendOrderDetailsAction extends ActionSupport implements SessionAware {
    final static Log logger = LogFactory.getLog(Sample.class);

    private Double totalPrice;
    private String date;
    private String username;
    private String address;
    private String name;
    private List<CartProduct> products;

    private Map<String, Object> session;

    @Autowired
    private PlaceOrderService placeOrderService;

    @Autowired
    private CartService cartService;

    @Override
    public String execute() {
        if (session.get("loggedUser") != null) {
            username = (String) session.get("loggedUser");
        } else {
            username = "anonymous";
        }

        logger.error("Username: " + username);

        this.products = cartService.findProductsByUsername(username);

        if (!placeOrderService.sendOrderDetails(username, name, date, address, totalPrice, products))
            return "error";

        return "success";
    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }

    public Map<String, Object> getSession() {
        return session;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public String getDate() {
        return date;
    }

    public String getUsername() {
        return username;
    }

    public String getAddress() {
        return address;
    }

    public List<CartProduct> getProducts() {
        return products;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setProducts(List<CartProduct> products) {
        this.products = products;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
