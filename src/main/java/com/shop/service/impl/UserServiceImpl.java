package com.shop.service.impl;

import com.shop.dao.UserDAO;
import com.shop.exception.ObjectAlreadyExistsException;
import com.shop.model.User;
import com.shop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Override
    public boolean register(String username, String password) {
        try {
            User user = createUser(username, password);

            return userDAO.register(user);
        } catch (ObjectAlreadyExistsException ex) {
            return false;
        }
    }

    @Override
    public boolean login(String username, String password) {
        User user = createUser(username, password);

        return userDAO.login(user);
    }

    protected User createUser(String username, String password) {
        User user = new User();

        user.setUsername(username);
        user.setPassword(password);

        return user;
    }
}
