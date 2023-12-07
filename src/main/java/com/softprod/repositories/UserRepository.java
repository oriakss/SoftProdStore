package com.softprod.repositories;

import com.softprod.entities.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {

    Optional<User> createUser(User user);

    Optional<List<User>> readUsers();

    Optional<User> updateUser(User user);

    Optional<User> deleteUser(Long userId);
}