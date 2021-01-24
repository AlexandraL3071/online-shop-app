package com.shop.dao;

import com.shop.model.CartProduct;
import com.shop.model.Product;

import java.util.List;

public interface CartProductDAO {

    void addToCart(CartProduct cartProduct);

    List<CartProduct> findProductsByUsername(String username);
}
