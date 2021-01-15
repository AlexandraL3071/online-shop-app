package com.shop.actions;

import com.opensymphony.xwork2.ActionSupport;
import com.shop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

public class RegisterUserAction extends ActionSupport {

    private String username;
    private String password;

    @Autowired
    private UserService userService;

    public String execute() {
        boolean isRegistered = userService.register(username, password);

        return isRegistered ? "success" : "failure";
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
