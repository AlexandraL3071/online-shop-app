package com.shop.dao.impl;

import com.shop.dao.CartProductDAO;
import com.shop.dao.UserDAO;
import com.shop.model.CartProduct;
import com.shop.model.Product;
import com.shop.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.stream.Collectors;

@Repository
@Transactional
public class CartProductDAOImpl implements CartProductDAO {

    @PersistenceContext(unitName = "onlineShop")
    private EntityManager manager;

    @Autowired
    private UserDAO userDAO;

    @Override
    public void addToCart(CartProduct cartProduct) {
        manager.merge(cartProduct);
    }

    @Override
    public List<CartProduct> findProductsByUsername(String username) {
        User user = new User();
        user.setUsername(username);
        User foundUser = userDAO.findUserByName(user);
        String queryString = "SELECT cp FROM CartProduct cp  WHERE cp.user=:user";
        TypedQuery<CartProduct> query = manager.createQuery(queryString, CartProduct.class);
        query.setParameter("user", foundUser);

        return query.getResultList();
    }
}
