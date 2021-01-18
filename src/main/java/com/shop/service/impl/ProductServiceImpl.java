package com.shop.service.impl;

import com.shop.dao.ProductDAO;
import com.shop.model.Product;
import com.shop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class ProductServiceImpl implements ProductService {

    private static final int NUMBER_OF_RECOMMENDED_PRODUCTS = 5;

    @Autowired
    private ProductDAO productDAO;

    @Override
    public boolean addProduct(String name, String description, int totalQuantity, double price, String image) {
        Product product = createProduct(name, description, totalQuantity, price, image);

        return productDAO.addProduct(product);
    }

    @Override
    public boolean deleteProduct(int productId) {
        return productDAO.deleteProduct(productId);
    }

    @Override
    public boolean updateProduct(int productId, String name, String description, int totalQuantity, double price, String image) {
        Product product = productDAO.findProductById(productId);
        product.setName(name);
        product.setDescription(description);
        product.setTotalQuantity(totalQuantity);
        product.setPrice(price);
        product.setImage(image);

        return productDAO.updateProduct(product);
    }

    @Override
    public List<Product> findAllProducts() {
        return productDAO.findAll();
    }

    @Override
    public Product findProductById(int productId) {
        return productDAO.findProductById(productId);
    }

    @Override
    public List<Product> findProductsByCategory(String category) {
        return productDAO.findProductsByCategory(category);
    }

    @Override
    public List<Product> findRecommendedProducts() {
        List<Product> products = findAllProducts();
        List<Product> recommendedProducts = new ArrayList<>();

        Random random = new Random();

        for (int i = 0; i < NUMBER_OF_RECOMMENDED_PRODUCTS; i++) {
            int randomIndex = random.nextInt(products.size());

            recommendedProducts.add(products.get(randomIndex));
        }

        return recommendedProducts;
    }

    protected Product createProduct(String name, String description, int totalQuantity, double price, String image) {
        Product product = new Product();

        product.setName(name);
        product.setDescription(description);
        product.setTotalQuantity(totalQuantity);
        product.setPrice(price);
        product.setImage(image);

        return product;
    }
}
