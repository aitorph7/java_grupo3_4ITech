package com.escuadronSuicida.backend.services;

import com.escuadronSuicida.backend.models.User;
import com.escuadronSuicida.backend.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public List<User> findAll() {
        return this.userRepository.findAll();
    }

    @Override
    public User findById(Long id) {
        return this.userRepository.findById(id).orElseThrow();
    }

    @Override
    public User createUser(User user) {
        Logger logger = LoggerFactory.getLogger(User.class);
        try {
            return userRepository.save(user);
        } catch (Exception e) {
            logger.error("Hubo un error al crear el usuario", e);
            throw new RuntimeException("Hubo un error al crear el usuario/a: " + e.getMessage(), e);
        }
    }

    @Override
    public User updateUserById(Long id, User user) {
        return null;
    }

    @Override
    public void deleteUserById(Long id) {
    }
}
