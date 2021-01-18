package com.shop.dao;

import com.shop.model.Category;

public interface CategoryDAO {
    Category findByName(String name);
}
