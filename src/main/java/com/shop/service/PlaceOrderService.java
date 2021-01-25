package com.shop.service;

import com.shop.model.CartProduct;
import com.shop.model.Product;

import java.util.List;

public interface PlaceOrderService {

    Double getTotalPrice(List<CartProduct> cartProducts);

    boolean sendOrderDetails(String username, String date, String address, Double price, List<CartProduct> cartProducts);
}
