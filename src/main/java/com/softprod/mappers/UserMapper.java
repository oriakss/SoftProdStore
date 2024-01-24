package com.softprod.mappers;

import com.softprod.entities.User;
import com.softprod.entities.UserRole;

import javax.servlet.http.HttpServletRequest;

import static com.softprod.entities.UserRole.valueOf;
import static com.softprod.utils.Constants.*;

public class UserMapper {

    private static UserMapper userMapper;

    public User buildUser(HttpServletRequest req) {
        return User.builder()
                .firstname(req.getParameter(USER_FIRSTNAME))
                .surname(req.getParameter(USER_SURNAME))
                .email(req.getParameter(USER_EMAIL))
                .login(req.getParameter(USER_LOGIN))
                .password(req.getParameter(USER_PASSWORD))
                .userRole(valueOf(req.getParameter(USER_ROLE)))
                .build();
    }

    public User buildUserManually(String firstname, String surname, String email, String login, String password, UserRole userRole) {
        return User.builder()
                .firstname(firstname)
                .surname(surname)
                .email(email)
                .login(login)
                .password(password)
                .userRole(userRole)
                .build();
    }

    public static UserMapper getInstance() {
        if (userMapper == null) {
            userMapper = new UserMapper();
        }
        return userMapper;
    }

    private UserMapper() {
    }
}