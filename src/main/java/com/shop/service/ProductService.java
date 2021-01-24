package com.shop.service;

import com.shop.model.Product;

import java.util.List;

public interface ProductService {
    int addProduct(String name, String description, int totalQuantity, double price, String image, String category);

    boolean deleteProduct(int productId);

    boolean updateProduct(int productId, int totalQuantity, double price);

    List<Product> findAllProducts();

    Product findProductById(int productId);

    Product findProductByName(String name);

    List<Product> findProductsByCategory(String category);

    List<Product> findRecommendedProducts();
}
