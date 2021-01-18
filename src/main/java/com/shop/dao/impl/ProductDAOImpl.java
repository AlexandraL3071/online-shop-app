package com.shop.dao.impl;

import com.shop.dao.CategoryDAO;
import com.shop.dao.ProductDAO;
import com.shop.model.Category;
import com.shop.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@Transactional
public class ProductDAOImpl implements ProductDAO {

    @PersistenceContext(unitName = "onlineShop")
    private EntityManager manager;

    @Autowired
    private CategoryDAO categoryDAO;

    @Override
    public boolean addProduct(Product product) {
        manager.merge(product);

        return true;
    }

    @Override
    public boolean deleteProduct(int productId) {
        Product product = findProductById(productId);

        if (product != null) {
            manager.remove(product);

            return true;
        }

        return false;
    }

    @Override
    public boolean updateProduct(Product product) {
        manager.merge(product);

        return true;
    }

    @Override
    public List<Product> findAll() {
        String queryString = "SELECT P FROM Product P";

        TypedQuery<Product> query = manager.createQuery(queryString, Product.class);

        return query.getResultList();
    }

    @Override
    public Product findProductById(int productId) {
        return manager.find(Product.class, productId);
    }

    @Override
    public List<Product> findProductsByCategory(String name) {
        Category category = categoryDAO.findByName(name);
        String queryString = "SELECT P FROM Product P where P.category = :category";

        TypedQuery<Product> query = manager.createQuery(queryString, Product.class);
        query.setParameter("category", category);

        return query.getResultList();
    }
}
