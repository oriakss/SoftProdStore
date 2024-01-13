package com.softprod.controllers;

import com.softprod.services.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.softprod.entities.UserRole.ADMIN;
import static com.softprod.services.UserServiceImpl.getInstance;
import static com.softprod.utils.Constants.*;

@WebServlet(urlPatterns = {ADMIN_MENU, USERS_MENU, PRODUCTS_MENU, ORDERS_MENU})
public class AdminController extends HttpServlet {

    private final UserService userService = getInstance();
    private final ProductService productService = ProductServiceImpl.getInstance();
    private final OrderService orderService = OrderServiceImpl.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        switch (req.getRequestURI()) {
            case ADMIN_MENU -> openAdminMenu(req, resp);
            case USERS_MENU -> openUsersMenu(req, resp);
            case PRODUCTS_MENU -> openProductsMenu(req, resp);
            case ORDERS_MENU -> openOrdersMenu(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    private void openOrdersMenu(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute(ORDERS, orderService.readOrders());
        req.getRequestDispatcher(ORDERS_MENU_PAGE).forward(req, resp);
    }

    private void openProductsMenu(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute(PRODUCTS, productService.readProducts());
        req.getRequestDispatcher(PRODUCTS_MENU_PAGE).forward(req, resp);
    }

    private void openUsersMenu(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute(USERS, userService.readUsers());
        req.getRequestDispatcher(USERS_MENU_PAGE).forward(req, resp);
    }

    private static void openAdminMenu(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().setAttribute(USER_ROLE, ADMIN);
        req.getRequestDispatcher(ADMIN_MENU_PAGE).forward(req, resp);
    }
}