package com.shop.actions;

import com.opensymphony.xwork2.ActionSupport;
import com.shop.model.Product;
import com.shop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;

public class ProductAction extends ActionSupport {

    private ArrayList<Product> productList = new ArrayList<Product>();
    private String category;

    @Autowired
    private ProductService productService;

    public String execute() {
        //productService.addProduct("Laptop","laptop description", 10,20,"image_path");
        //productService.addProduct("Laptop","laptop description", 10,20,"image_path");
        //productService.addProduct("Laptop","laptop description", 10,20,"image_path");

        if (category != null) {
            productList = (ArrayList<Product>) productService.findProductsByCategory(category);
        } else {
            productList = (ArrayList<Product>) productService.findAllProducts();
        }

        return "success";
    }

    public ArrayList<Product> getProductList() {
        return productList;
    }

    public void setProductList(ArrayList<Product> productList) {
        this.productList = productList;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
