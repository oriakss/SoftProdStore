package com.softprod.mappers;

import com.softprod.entities.Order;

import javax.servlet.http.HttpServletRequest;

import static com.softprod.utils.Constants.*;
import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;

public class OrderMapper {

    private static OrderMapper orderMapper;

    public Order buildOrder(HttpServletRequest req) {
        return Order.builder()
                .totalPrice(parseDouble(req.getParameter(ORDER_PRICE)))
                .productsNum(parseInt(req.getParameter(ORDER_PRODUCTS_NUM)))
                .status(req.getParameter(ORDER_STATUS))
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