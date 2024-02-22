package com.escuadronSuicida.backend.controller;

import com.escuadronSuicida.backend.model.User;
import com.escuadronSuicida.backend.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class UserController {

    private UserService userService;
    @GetMapping("users")
    public List<User> findAll() {return userService.findAll();}
    @GetMapping("users/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id) {return userService.findById(id);}

}
