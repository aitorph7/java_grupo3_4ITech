package com.escuadronSuicida.backend.services;

import com.escuadronSuicida.backend.models.User;

import java.util.List;
import java.util.Optional;

public interface UserService {


    List<User> findAll();

    Optional<User> findById(Long id);

    User create(User user);

    User updateUserById(Long id, User user);

    boolean deleteUserById(Long id);
}
