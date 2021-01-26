package com.shop.dao;

import com.shop.model.CustomOrder;

import java.util.List;

public interface CustomOrderDAO {

    List<CustomOrder> findAll();

    boolean addOrder(CustomOrder customOrder);

}
