package com.shop.dao.impl;

import com.shop.dao.CartProductDAO;
import com.shop.model.CartProduct;
import com.shop.model.Product;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.stream.Collectors;

public class CartProductDAOImpl implements CartProductDAO {

    @PersistenceContext(unitName = "onlineShop")
    private EntityManager manager;

    @Override
    public void addToCart(CartProduct cartProduct) {
        manager.merge(cartProduct);
    }

    @Override
    public List<Product> findProductsByUsername(String username) {
        String queryString = "SELECT cp FROM CartProduct cp " +
                "INNER JOIN User u ON cp.user_id = u.id " +
                "WHERE u.username = " + username;
        TypedQuery<CartProduct> cartProducts = manager.createQuery(queryString, CartProduct.class);

        return cartProducts.getResultList().stream()
                .map(CartProduct::getProduct)
                .collect(Collectors.toList());
    }
}
