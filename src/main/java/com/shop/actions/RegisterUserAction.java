package com.shop.actions;

import com.opensymphony.xwork2.ActionSupport;
import com.shop.service.UserService;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

public class RegisterUserAction extends ActionSupport implements SessionAware {

    private String username;
    private String password;

    private Map<String, Object> session;

    @Autowired
    private UserService userService;

    public String execute() {
        boolean isRegistered = userService.register(username, password);

        if (isRegistered) {
            session.put("loggedUser", username);
        }

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

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }
}
