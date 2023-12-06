package com.softprod.repositories;

import com.softprod.entities.User;

import java.util.List;
import java.util.Optional;

public interface AuthorizationRepository {

    Optional<User> logIn(List<User> users, User user);
}
