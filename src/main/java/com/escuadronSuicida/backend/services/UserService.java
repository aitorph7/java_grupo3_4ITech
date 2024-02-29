package com.escuadronSuicida.backend.services;

import com.escuadronSuicida.backend.models.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    List<User> findAll();
    User findById(Long id);
    User createUser(User user);
    User updateUserById(Long id, User user);
    void deleteUserById(Long id);
}
