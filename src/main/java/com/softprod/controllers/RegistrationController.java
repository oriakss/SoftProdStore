package com.softprod.controllers;

import com.softprod.entities.User;
import com.softprod.mappers.UserMapper;
import com.softprod.services.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static com.softprod.services.UserServiceImpl.getInstance;
import static com.softprod.utils.Constants.*;

@WebServlet(urlPatterns = REGISTRATION)
public class RegistrationController extends HttpServlet {

    private final UserService userService = getInstance();
    private final UserMapper userMapper = new UserMapper();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(REGISTRATION_PAGE).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user = userMapper.buildUser(req);
        userService.createUser(user);
        session.setAttribute(USER_ROLE, user.getUserRole());
        req.getRequestDispatcher(PRODUCTS_READ).forward(req, resp);
    }
}
