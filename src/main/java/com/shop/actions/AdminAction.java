package com.shop.actions;

import com.opensymphony.xwork2.ActionSupport;
import com.shop.model.CustomOrder;
import com.shop.model.Product;
import com.shop.service.CustomOrderService;
import com.shop.service.ProductService;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Map;

public class AdminAction extends ActionSupport implements SessionAware {
    private ArrayList<Product> allProductList = new ArrayList<Product>();
    private ArrayList<CustomOrder> allOrdersList = new ArrayList<CustomOrder>();
    private String category;
    private int totalQuantity;
    private double price;
    private int id;
    private String name;
    private String description;
    private String image;
    private String errorMessage;
    private Map<String, Object> session;

    @Autowired
    private ProductService productService;

    @Autowired
    private CustomOrderService customOrderService;

    public String execute() {
        if (!session.get("loggedUser").equals("admin")) {
            return "not_admin_user";
        }

        if (id!=0 && name==null && description==null && totalQuantity==0 && price==0.0 && image==null && category==null){
            productService.deleteProduct(id);
        }
        if (id!=0 && name==null && description==null && totalQuantity!=0 && price!=0.0 && image==null && category==null){
            productService.updateProduct(id,totalQuantity,price);
        }
        if (id==0 && name!=null && description!=null && totalQuantity!=0 && price!=0.0 && image!=null && category!=null){
            int addResult=productService.addProduct(name,description,totalQuantity,price,image,category);
            if (addResult==0){
                errorMessage="Categoria nu exista!";
                return "failure";
            }
            if (addResult==2){
                errorMessage="Un produs cu acest nume exista deja!";
                return "failure";
            }
        }

        allProductList = (ArrayList<Product>) productService.findAllProducts();

        allOrdersList = (ArrayList<CustomOrder>) customOrderService.findAllOrders();

        return "success";
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public ArrayList<Product> getAllProductList() {
        return allProductList;
    }

    public void setAllProductList(ArrayList<Product> allProductList) {
        this.allProductList = allProductList;
    }

    public int getTotalQuantity() {
        return totalQuantity;
    }

    public void setTotalQuantity(int totalQuantity) {
        this.totalQuantity = totalQuantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public ArrayList<CustomOrder> getAllOrdersList() {
        return allOrdersList;
    }

    public void setAllOrdersList(ArrayList<CustomOrder> allOrdersList) {
        this.allOrdersList = allOrdersList;
    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }
}
