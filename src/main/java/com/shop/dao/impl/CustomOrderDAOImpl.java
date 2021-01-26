package com.shop.dao.impl;

import com.shop.dao.CustomOrderDAO;
import com.shop.model.CustomOrder;
import com.shop.model.Product;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@Transactional
public class CustomOrderDAOImpl implements CustomOrderDAO {
    @PersistenceContext(unitName = "onlineShop")
    private EntityManager manager;

    @Override
    public List<CustomOrder> findAll() {
        String queryString = "SELECT C FROM CustomOrder C";

        TypedQuery<CustomOrder> query = manager.createQuery(queryString, CustomOrder.class);

        return query.getResultList();
    }

    @Override
    public boolean addOrder(CustomOrder customOrder) {
        manager.merge(customOrder);
        return true;
    }
}
