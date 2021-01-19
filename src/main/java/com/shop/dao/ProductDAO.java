package com.shop.dao;

import com.shop.exception.ObjectAlreadyExistsException;
import com.shop.model.Product;

import java.util.List;

public interface ProductDAO {

    boolean addProduct(Product product) throws ObjectAlreadyExistsException;

    boolean deleteProduct(int productId);

    boolean updateProduct(Product product);

    List<Product> findAll();

    Product findProductById(int productId);

    List<Product> findProductsByCategory(String category);

    Product findProductByName(Product product);
}
