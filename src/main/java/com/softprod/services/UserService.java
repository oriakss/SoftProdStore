package com.softprod.services;

import com.softprod.entities.User;

import java.util.List;

public interface UserService {

    void createUser(User user);

    List<User> readUsers();

    void updateUser(User user);

    void deleteUser(Long userId);
}