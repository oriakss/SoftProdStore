package com.softprod.controllers.user;

import com.softprod.services.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.softprod.services.UserServiceImpl.getInstance;
import static com.softprod.utils.Constants.*;

@WebServlet(urlPatterns = USERS_READ)
public class ReadUserController extends HttpServlet {

    private final UserService userService = getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute(USERS, userService.readUsers());
        req.getRequestDispatcher(USERS_READ_PAGE).forward(req, resp);
    }
}