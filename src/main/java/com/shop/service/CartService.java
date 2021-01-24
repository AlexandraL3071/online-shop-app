package com.shop.service;

import com.shop.model.CartProduct;
import com.shop.model.Product;

import java.util.List;

public interface CartService {

    void addToCart(CartProduct cartProduct);

    List<Product> findProductsByUserName(String username);
}
