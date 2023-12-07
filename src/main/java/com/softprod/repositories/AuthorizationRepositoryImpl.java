package com.softprod.repositories;

import com.softprod.entities.User;
import com.softprod.entities.UserRole;

import java.util.List;
import java.util.Optional;

public class AuthorizationRepositoryImpl implements AuthorizationRepository {

    private static AuthorizationRepository authorizationRepository;

    @Override
    public Optional<UserRole> checkUserByLoginAndPassword(List<User> users, String login, String password) {
        return users.stream()
                .filter(user -> user.getLogin().equals(login) && user.getPassword().equals(password))
                .map(User::getUserRole)
                .findAny();
    }

    public static AuthorizationRepository getInstance() {
        if (authorizationRepository == null) {
            authorizationRepository = new AuthorizationRepositoryImpl();
        }
        return authorizationRepository;
    }

    private AuthorizationRepositoryImpl() {
    }
}