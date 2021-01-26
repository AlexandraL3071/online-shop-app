package com.shop.service.impl;

import com.shop.dao.CartProductDAO;
import com.shop.model.CartProduct;
import com.shop.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    CartProductDAO cartProductDAO;

    @Override
    public void addToCart(CartProduct cartProduct) {
        cartProductDAO.addToCart(cartProduct);
    }

    @Override
    public List<CartProduct> findProductsByUsername(String username) {
        return cartProductDAO.findProductsByUsername(username);
    }
}
