package com.shop.actions;

import com.opensymphony.xwork2.ActionSupport;
import com.shop.dao.ProductDAO;
import com.shop.model.Product;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ProductAction extends ActionSupport {

    @Autowired
    private ProductDAO productDAO;

    public ProductAction(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    public List<Product> findAll() {
        return productDAO.findAll();
    }
}
