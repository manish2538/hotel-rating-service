package com.user.service.services;

import com.user.service.entities.User;

import java.util.List;

public interface UserService {

    User createUser(final User user);

    List<User> getAllUsers();

    User getUser(final String userId);

    User updateUser(final User user);

    void deleteUser(final String userId);

}
