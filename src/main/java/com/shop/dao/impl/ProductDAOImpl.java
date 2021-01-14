package com.shop.dao.impl;

import com.shop.dao.ProductDAO;
import com.shop.model.Product;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductDAOImpl implements ProductDAO {

    @PersistenceContext(unitName  = "onlineShop")
    private EntityManager manager;

    @Override
    public boolean addProduct(Product product) {
        return false;
    }

    @Override
    public boolean deleteProduct(int productId) {
        return false;
    }

    @Override
    public void updateProduct(Product product) {

    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>();
    }
}
