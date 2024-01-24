package com.softprod.mappers;

import com.softprod.entities.Order;
import com.softprod.entities.OrderStatus;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;

import static com.softprod.entities.OrderStatus.valueOf;
import static com.softprod.utils.Constants.*;
import static java.lang.Integer.parseInt;
import static java.util.UUID.randomUUID;

public class OrderMapper {

    private static OrderMapper orderMapper;

    public Order buildOrder(HttpServletRequest req) {
        return Order.builder()
                .uuid(randomUUID())
                .totalPrice(new BigDecimal(req.getParameter(ORDER_PRICE)))
                .productsNum(parseInt(req.getParameter(ORDER_PRODUCTS_NUM)))
                .status(valueOf(req.getParameter(ORDER_STATUS)))
                .build();
    }

    public Object buildOrderManually(BigDecimal totalPrice, int productsNum, OrderStatus orderStatus) {
        return Order.builder()
                .uuid(randomUUID())
                .totalPrice(totalPrice)
                .productsNum(productsNum)
                .status(orderStatus)
                .build();
    }

    public static OrderMapper getInstance() {
        if (orderMapper == null) {
            orderMapper = new OrderMapper();
        }
        return orderMapper;
    }

    private OrderMapper() {
    }
}