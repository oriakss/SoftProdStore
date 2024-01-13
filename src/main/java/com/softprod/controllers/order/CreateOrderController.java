package com.softprod.controllers.order;

import com.softprod.mappers.OrderMapper;
import com.softprod.services.OrderService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.softprod.services.OrderServiceImpl.getInstance;
import static com.softprod.utils.Constants.*;

@WebServlet(urlPatterns = ORDERS_CREATE)
public class CreateOrderController extends HttpServlet {

    private final OrderService orderService = getInstance();
    private final OrderMapper orderMapper = OrderMapper.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(ORDERS_CREATE_PAGE).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        orderService.createOrder(orderMapper.buildOrder(req));
        req.getRequestDispatcher(ORDERS_MENU).forward(req, resp);
    }
}