package com.shop.service.impl;

import com.shop.dao.CartProductDAO;
import com.shop.model.CartProduct;
import com.shop.model.Product;
import com.shop.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CartServiceImpl implements CartService {

    @Autowired
    CartProductDAO cartProductDAO;

    @Override
    public void addToCart(CartProduct cartProduct) {
        cartProductDAO.addToCart(cartProduct);
    }

    @Override
    public List<Product> findProductsByUserName(String username) {
        return cartProductDAO.findProductsByUsername(username);
    }
}
