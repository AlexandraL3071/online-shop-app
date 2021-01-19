package com.shop.service.impl;

import com.shop.dao.CategoryDAO;
import com.shop.dao.ProductDAO;
import com.shop.exception.ObjectAlreadyExistsException;
import com.shop.model.Category;
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

    @Autowired
    private CategoryDAO categoryDAO;

    @Override
    public int addProduct(String name, String description, int totalQuantity, double price, String image, String category) {
        Product product = createProduct(name, description, totalQuantity, price, image, category);

        if (product==null){
            return 0;
        }
        try {
            productDAO.addProduct(product);
            return 1;
        }catch(ObjectAlreadyExistsException exception){
            return 2;
        }
    }

    @Override
    public boolean deleteProduct(int productId) {
        return productDAO.deleteProduct(productId);
    }

    @Override
    public boolean updateProduct(int productId, int totalQuantity, double price) {
        Product product = productDAO.findProductById(productId);
        product.setTotalQuantity(totalQuantity);
        product.setPrice(price);

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

    protected Product createProduct(String name, String description, int totalQuantity, double price, String image, String category) {
        Product product = new Product();

        Category category1=categoryDAO.findByName(category);
        if (category1==null){
            return null;
        }
        product.setName(name);
        product.setDescription(description);
        product.setTotalQuantity(totalQuantity);
        product.setPrice(price);
        product.setImage(image);
        product.setCategory(category1);

        return product;
    }
}
