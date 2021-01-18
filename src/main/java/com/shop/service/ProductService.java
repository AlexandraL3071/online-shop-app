package com.shop.service;

import com.shop.model.Product;

import java.util.List;

public interface ProductService {
    boolean addProduct(String name, String description, int totalQuantity, double price, String image);

    boolean deleteProduct(int productId);

    boolean updateProduct(int productId, String name, String description, int totalQuantity, double price, String image);

    List<Product> findAllProducts();

    Product findProductById(int productId);

   List<Product> findProductsByCategory(String category);

   List<Product> findRecommendedProducts();
}
