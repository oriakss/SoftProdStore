package com.softprod.repositories;

import com.softprod.entities.User;
import com.softprod.entities.UserRole;

import java.util.List;
import java.util.Optional;

public interface AuthorizationRepository {

    Optional<UserRole> checkUserByLoginAndPassword(List<User> users, String login, String password);
}