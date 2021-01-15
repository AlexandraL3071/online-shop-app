package com.shop.dao.impl;

import com.shop.dao.UserDAO;
import com.shop.exception.ObjectAlreadyExistsException;
import com.shop.model.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@Transactional
public class UserDAOImpl implements UserDAO {

    @PersistenceContext(unitName = "onlineShop")
    private EntityManager manager;

    @Override
    public boolean login(User user) {
        return findUser(user) != null;
    }

    @Override
    public boolean register(User user) throws ObjectAlreadyExistsException {
        User foundUser = findUserByName(user);

        if (foundUser == null) {
            manager.merge(user);

            return true;
        }

        throw new ObjectAlreadyExistsException("Exista deja un cont cu acest nume de utilizator");
    }

    @Override
    public User findUser(User user) {
        String username = user.getUsername();
        String password = user.getPassword();

        String queryString = "SELECT U FROM User U WHERE U.username = :username AND U.password = :password";

        TypedQuery<User> query = manager.createQuery(queryString, User.class);
        query.setParameter("username", username);
        query.setParameter("password", password);

        List<User> users = query.getResultList();

        return users.size() == 0 ? null : users.get(0);
    }

    @Override
    public User findUserByName(User user) {
        String username = user.getUsername();

        String queryString = "SELECT U FROM User U WHERE U.username = :username";

        TypedQuery<User> query = manager.createQuery(queryString, User.class);
        query.setParameter("username", username);

        List<User> users = query.getResultList();

        return users.size() == 0 ? null : users.get(0);
    }
}
