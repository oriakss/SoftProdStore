package com.softprod.repositories;

import com.softprod.entities.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static com.softprod.entities.UserRole.ADMIN;
import static com.softprod.entities.UserRole.USER;
import static com.softprod.utils.Constants.DEFAULT_ID;
import static com.softprod.utils.Constants.ONE_STEP;

public class UserRepositoryImpl implements UserRepository {

    private static UserRepository userRepository;
    private final List<User> users = new ArrayList<>();

    @Override
    public Optional<User> createUser(User user) {
        if (users.isEmpty()) {
            user.setId(DEFAULT_ID);
        } else {
            user.setId(users.get(users.size() - ONE_STEP).getId() + DEFAULT_ID);
        }
        users.add(user);
        return Optional.of(user);
    }

    @Override
    public Optional<List<User>> readUsers() {
        return Optional.of(users);
    }

    @Override
    public Optional<User> updateUser(User user) {
        User oldUser = users.stream()
                .filter(item -> Objects.equals(item.getId(), user.getId()))
                .findAny().orElseThrow();
        int ind = users.indexOf(oldUser);
        users.remove(ind);
        users.add(ind, user);
        return Optional.of(user);
    }

    @Override
    public Optional<User> deleteUser(Long userId) {
        User user = users.stream()
                .filter(item -> Objects.equals(item.getId(), userId))
                .findAny().orElseThrow();
        users.remove(user);
        return Optional.of(user);
    }

    public static UserRepository getInstance() {
        if (userRepository == null) {
            userRepository = new UserRepositoryImpl();
        }
        return userRepository;
    }

    private UserRepositoryImpl() {
        users.add(new User(1L, "Admin", "1", "admin@admin.com",
                "admin", "admin", ADMIN));
        users.add(new User(2L, "User", "1", "user1@user.com",
                "user1", "user1", USER));
        users.add(new User(3L, "User", "2", "user2@user.com",
                "user2", "user2", USER));
        users.add(new User(4L, "User", "3", "user3@user.com",
                "user3", "user3", USER));
        users.add(new User(5L, "User", "4", "user4@user.com",
                "user4", "user4", USER));
    }
}