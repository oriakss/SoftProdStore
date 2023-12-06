package com.softprod.controllers;

import com.softprod.entities.User;
import com.softprod.entities.UserRole;
import com.softprod.services.AuthorizationService;
import com.softprod.services.AuthorizationServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static com.softprod.utils.Constants.*;

@WebServlet(urlPatterns = LOGIN)
public class AuthorizationController extends HttpServlet {

    private final AuthorizationService authorizationService = AuthorizationServiceImpl.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = new User();
        user.setLogin(req.getParameter(USER_LOGIN));
        user.setPassword(req.getParameter(USER_PASSWORD));
        UserRole userRole = authorizationService.logIn(user).getUserRole();
        HttpSession session = req.getSession();
        switch (userRole) {
            case ADMIN -> {
                session.setAttribute(USER_ROLE, userRole);
                req.getRequestDispatcher(ADMIN_MENU).forward(req, resp);
            }
            case USER -> {
                session.setAttribute(USER_ROLE, userRole);
                req.getRequestDispatcher(PRODUCTS_READ).forward(req, resp);
            }
            default -> req.getRequestDispatcher(LOGIN_ERROR).forward(req, resp);
        }
    }
}
