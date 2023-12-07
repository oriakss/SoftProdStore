package com.softprod.services;

import com.softprod.entities.UserRole;

public interface AuthorizationService {

    UserRole checkUserByLoginAndPassword(String login, String password);
}