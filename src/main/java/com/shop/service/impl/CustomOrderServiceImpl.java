package com.shop.service.impl;

import com.shop.dao.CustomOrderDAO;
import com.shop.model.CustomOrder;
import com.shop.model.Product;
import com.shop.service.CustomOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomOrderServiceImpl implements CustomOrderService {

    @Autowired
    private CustomOrderDAO customOrderDAO;

    @Override
    public List<CustomOrder> findAllOrders() {
        return customOrderDAO.findAll();
    }
}
