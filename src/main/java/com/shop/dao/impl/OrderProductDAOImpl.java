package com.shop.dao.impl;

import com.shop.dao.OrderProductDAO;
import com.shop.model.OrderProduct;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class OrderProductDAOImpl implements OrderProductDAO {
    @PersistenceContext(unitName = "onlineShop")
    private EntityManager manager;

    @Override
    public boolean addOrderProduct(OrderProduct orderProduct) {
        manager.merge(orderProduct);
        return true;
    }
}
