package com.softprod.controllers.order;

import com.softprod.services.OrderService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.softprod.services.OrderServiceImpl.getInstance;
import static com.softprod.utils.Constants.*;

@WebServlet(urlPatterns = ORDERS_READ)
public class ReadOrderController extends HttpServlet {

    private final OrderService orderService = getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute(ORDERS, orderService.readOrders());
        req.getRequestDispatcher(ORDERS_READ_PAGE).forward(req, resp);
    }
}