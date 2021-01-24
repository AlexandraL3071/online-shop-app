package com.shop.actions;

import com.opensymphony.xwork2.ActionSupport;
import com.shop.dao.UserDAO;
import com.shop.model.CartProduct;
import com.shop.model.Product;
import com.shop.model.User;
import com.shop.service.CartService;
import com.shop.service.ProductService;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

public class AddToCartAction extends ActionSupport implements SessionAware {

    private int productId;
    private Map<String, Object> session;

    @Autowired
    private UserDAO userService;

    @Autowired
    private ProductService productService;

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

        User userByUsername = new User();
        userByUsername.setUsername(username);
        User user = userService.findUserByName(userByUsername);
        Product product = productService.findProductById(productId);
        CartProduct cartProduct = new CartProduct();
        cartProduct.setUser(user);
        cartProduct.setProduct(product);
        cartService.addToCart(cartProduct);

        return "success";
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }


}
