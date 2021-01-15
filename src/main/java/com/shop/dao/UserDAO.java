package com.shop.dao;

import com.shop.exception.ObjectAlreadyExistsException;
import com.shop.model.User;

public interface UserDAO {

    boolean login(User user);

    boolean register(User user) throws ObjectAlreadyExistsException;

    User findUser(User user);

    User findUserByName(User user);
}
