package com.shop.service.impl;

import com.shop.dao.CartProductDAO;
import com.shop.dao.CustomOrderDAO;
import com.shop.dao.OrderProductDAO;
import com.shop.dao.UserDAO;
import com.shop.model.*;
import com.shop.service.PlaceOrderService;
import javassist.tools.reflect.Sample;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class PlaceOrderImpl implements PlaceOrderService {
    final static Log logger = LogFactory.getLog(Sample.class);

    @Autowired
    private UserDAO userService;

    @Autowired
    private CustomOrderDAO customOrderDAO;

    @Autowired
    private OrderProductDAO orderProductDAO;

    @Autowired
    private CartProductDAO cartProductDAO;

    @Override
    public Double getTotalPrice(List<CartProduct> cartProducts) {
        Optional<Double> sum = cartProducts.stream().map(cartProduct -> cartProduct.getProduct().getPrice() * cartProduct.getSelectedQuantity()).reduce(Double::sum);
        AtomicReference<Double> realSum = new AtomicReference<>();
        sum.ifPresent(realSum::set);
        return realSum.get();
    }

    @Override
    public boolean sendOrderDetails(String username, String date, String address, Double price, List<CartProduct> cartProducts) {
        CustomOrder customOrder = new CustomOrder();
        logger.error("Begin sendOrderDetails...");
        logger.error("Date: " + date);
        logger.error("User: " + username);

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSSSS");
        format.setTimeZone(TimeZone.getTimeZone("GMT"));
        try {
            Date formatDate = format.parse(date);
            customOrder.setOrderDate(formatDate);
        } catch (ParseException e) {
            logger.error(e);
            return false;
        }


        User userByUsername = new User();
        userByUsername.setUsername(username);
        User user = userService.findUserByName(userByUsername);

        logger.error("User: " + user);

        customOrder.setUser(user);
        customOrder.setDeliveryAddress(address);

        logger.error("Address: " + address);
        customOrder.setTotalPrice(price);

        logger.error("Price: " + price);

        List<OrderProduct> orderProductList = new ArrayList<>();
        cartProducts.forEach(cartProduct -> {
            logger.error("Cart Product: " + cartProduct);
            OrderProduct orderProduct = new OrderProduct();
            orderProduct.setProduct(cartProduct.getProduct());
            orderProduct.setSelectedQuantity(cartProduct.getSelectedQuantity());
            orderProduct.setCustomOrder(customOrder);
            orderProductList.add(orderProduct);
            orderProductDAO.addOrderProduct(orderProduct);
        });

        customOrder.setOrderProducts(orderProductList);
        customOrderDAO.addOrder(customOrder);

        cartProductDAO.deleteFromCart(user);

        return true;
    }
}
