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
import static java.lang.Long.valueOf;

@WebServlet(urlPatterns = USERS_DELETE)
public class DeleteUserController extends HttpServlet {

    private final UserService userService = getInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        userService.deleteUser(valueOf(req.getParameter(ID)));
        req.getRequestDispatcher(USERS_MENU).forward(req, resp);
    }
}