package com.shop.actions;

import com.opensymphony.xwork2.ActionSupport;
import com.shop.dao.UserDAO;
import com.shop.model.CartProduct;
import com.shop.model.Product;
import com.shop.model.User;
import com.shop.service.CartService;
import com.shop.service.ProductService;
import com.shop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

public class AddToCartAction extends ActionSupport {

    private String userName;

    private int productId;

    private UserDAO userService;

    private ProductService productService;

    private CartService cartService;

    @Autowired
    public AddToCartAction(UserDAO userService, ProductService productService, CartService cartService) {
        this.userService = userService;
        this.productService = productService;
        this.cartService = cartService;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    @Override
    public String execute() {
        User userByUsername = new User();
        userByUsername.setUsername(userName);
        User user = userService.findUserByName(userByUsername);
        Product product = productService.findProductById(productId);
        CartProduct cartProduct = new CartProduct();
        cartProduct.setUser(user);
        cartProduct.setProduct(product);
        cartService.addToCart(cartProduct);

        return "success";
    }
}
