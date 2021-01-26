package com.shop.dao;

import com.shop.model.CartProduct;
import com.shop.model.User;

import java.util.List;

public interface CartProductDAO {

    void addToCart(CartProduct cartProduct);

    List<CartProduct> findProductsByUsername(String username);

    void deleteFromCart(User user);
}
