package com.escuadronSuicida.backend.services;

import com.escuadronSuicida.backend.models.User;

import java.util.List;

public interface UserService {
    List<User> findUser();
    User findById(Long id);
}
