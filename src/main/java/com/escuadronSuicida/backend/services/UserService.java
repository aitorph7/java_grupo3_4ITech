package com.escuadronSuicida.backend.services;

import com.escuadronSuicida.backend.models.User;

import java.util.List;

public interface UserService {


    List<User> findAll();

    User findById(Long id);

    User create(User user);

    User updateUserById(Long id, User user);

    boolean deleteUserById(Long id);
}
