package com.shop.dao;

import com.shop.model.CustomOrder;
import com.shop.model.Product;

import java.util.List;

public interface CustomOrderDAO {

    List<CustomOrder> findAll();

    boolean addOrder(CustomOrder customOrder);

}
