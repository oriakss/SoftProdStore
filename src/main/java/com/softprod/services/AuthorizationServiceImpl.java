package com.softprod.services;

import com.softprod.entities.User;
import com.softprod.repositories.AuthorizationRepository;
import com.softprod.repositories.AuthorizationRepositoryImpl;

public class AuthorizationServiceImpl implements AuthorizationService {

    private static AuthorizationService authorizationService;

    private final AuthorizationRepository authorizationRepository = AuthorizationRepositoryImpl.getInstance();
    private final UserService userService = UserServiceImpl.getInstance();

    private AuthorizationServiceImpl() {}

    @Override
    public User logIn(User user) {
        return authorizationRepository.logIn(userService.readUsers(), user).orElse(new User());
    }

    public static AuthorizationService getInstance() {
        if (authorizationService == null) {
            authorizationService = new AuthorizationServiceImpl();
        }
        return authorizationService;
    }
}
