package com.softprod.mappers;

import com.softprod.entities.User;
import com.softprod.entities.UserRole;

import javax.servlet.http.HttpServletRequest;

import static com.softprod.utils.Constants.*;

public class UserMapper {

    public User buildUser(HttpServletRequest req) {
        return User.builder()
                .firstname(req.getParameter(USER_FIRSTNAME))
                .surname(req.getParameter(USER_SURNAME))
                .email(req.getParameter(USER_EMAIL))
                .login(req.getParameter(USER_LOGIN))
                .password(req.getParameter(USER_PASSWORD))
                .userRole(UserRole.valueOf(req.getParameter(USER_ROLE)))
                .build();
    }
}
