package com.escuadronSuicida.backend.controller;

import com.escuadronSuicida.backend.models.User;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@NoArgsConstructor
public class UserController {
    List<User> users;

    @GetMapping("users")
    public ResponseEntity<List<User>> findAll() {
        return ResponseEntity.ok(this.users);
    }

}
