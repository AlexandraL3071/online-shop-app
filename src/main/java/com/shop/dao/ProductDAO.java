package com.shop.dao;

import com.shop.model.Product;

import java.util.List;

public interface ProductDAO {

	boolean addProduct(Product product);

	boolean deleteProduct(int productId);

	void updateProduct(Product product);

	List<Product> findAll();
}
