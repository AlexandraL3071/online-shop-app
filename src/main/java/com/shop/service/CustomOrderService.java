package com.shop.service;

import com.shop.model.CustomOrder;
import com.shop.model.Product;

import java.util.List;

public interface CustomOrderService {

    List<CustomOrder> findAllOrders();
}
