package com.softprod.repositories;

import com.softprod.entities.User;

import java.util.List;
import java.util.Optional;

public class AuthorizationRepositoryImpl implements AuthorizationRepository {

    private static AuthorizationRepository authorizationRepository;

    private AuthorizationRepositoryImpl() {
    }

    @Override
    public Optional<User> logIn(List<User> users, User user) {
        return users.stream()
                .filter(item -> item.getLogin().equals(user.getLogin()) && item.getPassword().equals(user.getPassword()))
                .findAny();
    }

    public static AuthorizationRepository getInstance() {
        if (authorizationRepository == null) {
            authorizationRepository = new AuthorizationRepositoryImpl();
        }
        return authorizationRepository;
    }
}
