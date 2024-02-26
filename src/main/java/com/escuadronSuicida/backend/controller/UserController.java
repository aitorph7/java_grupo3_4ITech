package com.escuadronSuicida.backend.controller;

import com.escuadronSuicida.backend.models.User;
import com.escuadronSuicida.backend.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
public class UserController {
    List<User> users;
    private final UserRepository userRepository;

    @GetMapping("users")
    public List<User> findAll(){
        return userRepository.findAll();
    }
    @GetMapping("users/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent())
            return ResponseEntity.ok(userOptional.get());
        else
            return ResponseEntity.notFound().build();
    }
}
