package com.shop.dao.impl;

import com.shop.dao.CategoryDAO;
import com.shop.model.Category;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@Transactional
public class CategoryDAOImpl implements CategoryDAO {

    @PersistenceContext(unitName = "onlineShop")
    private EntityManager manager;

    @Override
    public Category findByName(String name) {
        String queryString = "SELECT C FROM Category C where C.name = :name";

        TypedQuery<Category> query = manager.createQuery(queryString, Category.class);
        query.setParameter("name", name);

        List<Category> categories = query.getResultList();

        return categories.size() == 0 ? null : categories.get(0);
    }
}
