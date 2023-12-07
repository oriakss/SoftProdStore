package com.softprod.services;

import com.softprod.entities.User;

import java.util.List;

public interface UserService {

    User createUser(User user);

    List<User> readUsers();

    User updateUser(User user);

    User deleteUser(Long userId);
}