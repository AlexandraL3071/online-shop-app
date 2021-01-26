package com.shop.service;

import com.shop.model.CustomOrder;

import java.util.List;

public interface CustomOrderService {

    List<CustomOrder> findAllOrders();
}
