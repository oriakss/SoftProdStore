package com.softprod.controllers;

import com.softprod.entities.Order;
import com.softprod.services.OrderService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

import static com.softprod.services.OrderServiceImpl.getInstance;
import static com.softprod.utils.Constants.*;

@WebServlet(urlPatterns = ORDERS_READ)
public class ReadOrderController extends HttpServlet {

    private final OrderService orderService = getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Order> orders = orderService.readOrders();
        req.setAttribute(ORDERS, orders);
        req.getRequestDispatcher(ORDERS_READ_PAGE).forward(req, resp);
    }
}
