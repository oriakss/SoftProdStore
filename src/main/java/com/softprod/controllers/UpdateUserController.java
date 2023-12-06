package com.softprod.controllers;

import com.softprod.entities.User;
import com.softprod.mappers.UserMapper;
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

@WebServlet(urlPatterns = USERS_UPDATE)
public class UpdateUserController extends HttpServlet {

    private final UserService userService = getInstance();
    private final UserMapper userMapper = new UserMapper();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = userMapper.buildUser(req);
        user.setId(valueOf(req.getParameter(ID)));
        userService.updateUser(user);
        req.getRequestDispatcher(USERS_MENU).forward(req, resp);
    }
}
