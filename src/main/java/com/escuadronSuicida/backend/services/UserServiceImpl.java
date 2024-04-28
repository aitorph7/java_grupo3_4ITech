package com.escuadronSuicida.backend.services;

import com.escuadronSuicida.backend.models.User;
import com.escuadronSuicida.backend.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()){
            User userFromDatabase = userOptional.get();
            userFromDatabase.setFirstName(user.getFirstName());
            userFromDatabase.setLastName(user.getLastName());
            userFromDatabase.setEmail(user.getEmail());
            userFromDatabase.setPhone(user.getPhone());
            userFromDatabase.setUserName(user.getUserName());
            userFromDatabase.setPassword(user.getPassword());
            userFromDatabase.setAddress(user.getAddress());
            userFromDatabase.setUserRole(user.getUserRole());
            userFromDatabase.setPhotoUrl(user.getPhotoUrl());

            return userRepository.save(userFromDatabase);
        } else
            return null;
    }

    @Override
    public boolean deleteUserById(Long id) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()){
            userRepository.deleteById(id);
            return true;
        } else
            return false;
    }
}
