package com.shop.actions;

import com.opensymphony.xwork2.ActionSupport;
import com.shop.dao.ProductDAO;
import com.shop.model.Product;
import com.shop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class ProductAction extends ActionSupport {

    private ArrayList<Product> productList=new ArrayList<Product>();

    @Autowired
    private ProductService productService;

    public String execute() {
        productService.addProduct("Laptop","laptop description", 10,20,"image_path");
        productService.addProduct("Laptop","laptop description", 10,20,"image_path");
        productService.addProduct("Laptop","laptop description", 10,20,"image_path");
        productList= (ArrayList<Product>) productService.findAllProducts();

        return "success";
    }

    public ArrayList<Product> getProductList() {
        return productList;
    }

    public void setProductList(ArrayList<Product> productList) {
        this.productList = productList;
    }
}
