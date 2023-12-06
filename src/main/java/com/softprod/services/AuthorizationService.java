package com.softprod.services;

import com.softprod.entities.User;

public interface AuthorizationService {

    User logIn(User user);
}
