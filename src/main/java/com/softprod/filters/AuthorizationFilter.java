package com.softprod.filters;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.softprod.entities.UserRole.ADMIN;
import static com.softprod.utils.Constants.*;

@WebFilter(urlPatterns = {ADMIN_MENU, USERS_ALL_PAGES, PRODUCTS_ALL_PAGES, ORDERS_ALL_PAGES})
public class AuthorizationFilter extends HttpFilter {

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        Object userRole = req.getSession().getAttribute(USER_ROLE);
        if (userRole == ADMIN) {
            chain.doFilter(req, res);
        } else {
            req.getRequestDispatcher(ACCESS_ERROR).forward(req, res);
        }
    }
}