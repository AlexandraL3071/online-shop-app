package com.shop.service;

import com.shop.model.CartProduct;

import java.util.List;

public interface PlaceOrderService {

    Double getTotalPrice(List<CartProduct> cartProducts);

    boolean sendOrderDetails(String username, String name, String date, String address, Double price,
                             List<CartProduct> cartProducts);
}
