package com.softprod.controllers.order;

import com.softprod.entities.OrderStatus;
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

@WebServlet(urlPatterns = ORDERS_UPDATE)
public class UpdateOrderController extends HttpServlet {

    private final OrderService orderService = getInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        orderService.updateOrder(parseLong(req.getParameter(ID)), OrderStatus.valueOf(req.getParameter(ORDER_STATUS)));
        req.getRequestDispatcher(ORDERS_MENU).forward(req, resp);
    }
}