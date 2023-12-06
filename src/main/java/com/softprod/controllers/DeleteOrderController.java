package com.softprod.controllers;

import com.softprod.entities.Order;
import com.softprod.services.OrderService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.softprod.services.OrderServiceImpl.getInstance;
import static com.softprod.utils.Constants.*;
import static java.lang.Long.parseLong;

@WebServlet(urlPatterns = ORDERS_DELETE)
public class DeleteOrderController extends HttpServlet {

    private final OrderService orderService = getInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Order order = new Order();
        order.setId(parseLong(req.getParameter(ID)));
        orderService.deleteOrder(order);
        req.getRequestDispatcher(ORDERS_MENU).forward(req, resp);
    }
}
