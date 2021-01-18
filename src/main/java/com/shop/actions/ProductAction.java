package com.shop.actions;

import com.opensymphony.xwork2.ActionSupport;
import com.shop.model.Product;
import com.shop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProductAction extends ActionSupport {

    private ArrayList<Product> productList = new ArrayList<Product>();
    private String category;
    private List<String> title;

    @Autowired
    private ProductService productService;

    public String execute() {
        //productService.addProduct("Laptop","laptop description", 10,20,"image_path");
        //productService.addProduct("Laptop","laptop description", 10,20,"image_path");
        //productService.addProduct("Laptop","laptop description", 10,20,"image_path");

        if (category != null) {
            title = Collections.singletonList(processSectionTitle(category));
            productList = (ArrayList<Product>) productService.findProductsByCategory(category);
        } else {
            title = Collections.singletonList("Produse recomandate");
            productList = (ArrayList<Product>) productService.findRecommendedProducts();
        }

        return "success";
    }

    protected String processSectionTitle(String title) {
        if (title.equals("Laptopuri")) {
            return "Laptop-uri";
        } else if (title.equals("ComponentePC")) {
            return "Componente PC";
        } else {
            return title;
        }
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

    public List<String> getTitle() {
        return title;
    }

    public void setTitle(List<String> title) {
        this.title = title;
    }
}
