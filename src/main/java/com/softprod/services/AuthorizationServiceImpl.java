package com.softprod.services;

import com.softprod.entities.UserRole;
import com.softprod.repositories.AuthorizationRepository;
import com.softprod.repositories.AuthorizationRepositoryImpl;

import static com.softprod.entities.UserRole.NO_ROLE;

public class AuthorizationServiceImpl implements AuthorizationService {

    private static AuthorizationService authorizationService;
    private final AuthorizationRepository authorizationRepository = AuthorizationRepositoryImpl.getInstance();
    private final UserService userService = UserServiceImpl.getInstance();

    @Override
    public UserRole checkUserByLoginAndPassword(String login, String password) {
        return authorizationRepository
                .checkUserByLoginAndPassword(userService.readUsers(), login, password)
                .orElse(NO_ROLE);
    }

    public static AuthorizationService getInstance() {
        if (authorizationService == null) {
            authorizationService = new AuthorizationServiceImpl();
        }
        return authorizationService;
    }

    private AuthorizationServiceImpl() {
    }
}