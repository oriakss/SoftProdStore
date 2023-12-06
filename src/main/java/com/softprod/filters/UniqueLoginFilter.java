package com.softprod.filters;

import com.softprod.entities.User;
import com.softprod.services.UserService;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

import static com.softprod.services.UserServiceImpl.getInstance;
import static com.softprod.utils.Constants.*;

@WebFilter(urlPatterns = {REGISTRATION, USERS_CREATE})
public class UniqueLoginFilter extends HttpFilter {
    
    UserService userService = getInstance();

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        Optional<User> optionalUser = userService.readUsers().stream()
                .filter(user -> user.getLogin().equals(req.getParameter(USER_LOGIN)))
                .findAny();
        if (optionalUser.isPresent()) {
            req.getRequestDispatcher(REGISTRATION_ERROR).forward(req, res);
        } else {
            chain.doFilter(req, res);
        }
    }
}
