package com.shop.actions;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;

import java.util.Map;

public class LogoutUserAction extends ActionSupport implements SessionAware {

    private Map<String, Object> session;

    public String execute() {
        session.put("loggedUser", "");

        return "success";
    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }
}
