package com.softprod.controllers;

import com.softprod.entities.UserRole;
import com.softprod.services.AuthorizationService;
import com.softprod.services.AuthorizationServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.softprod.utils.Constants.*;

@WebServlet(urlPatterns = LOGIN)
public class AuthorizationController extends HttpServlet {

    private final AuthorizationService authorizationService = AuthorizationServiceImpl.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserRole userRole = authorizationService
                .checkUserByLoginAndPassword(req.getParameter(USER_LOGIN), req.getParameter(USER_PASSWORD));
        switch (userRole) {
            case ADMIN -> openAdminMenu(req, resp, userRole);
            case USER -> openProductList(req, resp, userRole);
            default -> req.getRequestDispatcher(LOGIN_ERROR).forward(req, resp);
        }
    }

    private static void openProductList(HttpServletRequest req, HttpServletResponse resp, UserRole userRole) throws ServletException, IOException {
        req.getSession().setAttribute(USER_ROLE, userRole);
        req.getRequestDispatcher(PRODUCTS_READ).forward(req, resp);
    }

    private static void openAdminMenu(HttpServletRequest req, HttpServletResponse resp, UserRole userRole) throws ServletException, IOException {
        req.getSession().setAttribute(USER_ROLE, userRole);
        req.getRequestDispatcher(ADMIN_MENU).forward(req, resp);
    }
}