package com.escuadronSuicida.backend.services;

import com.escuadronSuicida.backend.models.User;
//import com.escuadronSuicida.backend.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Javadoc
 * clase de operaciones para trabajar con métodos CRUD
 * sobre objetos de tipo User.
 */
//@Service
//@AllArgsConstructor
//public class UserService {

//    private UserRepository userRepository;

    // TODO 1 inyectar el TicketService
//    @GetMapping("users")
//    public List<User> findAll() {return userRepository.findAll();}
//
//    @GetMapping("users/{id}")
//    public ResponseEntity<User> findById(@PathVariable Long id){
//        Optional<User> userOptional = userRepository.findById(id);
//        if (userOptional.isPresent())
//            return ResponseEntity.ok(userOptional.get());
//        else
//            return ResponseEntity.notFound().build();
//    }
//    @PostMapping("users")
//    public ResponseEntity<User> create(@RequestBody User user){
//        return ResponseEntity.ok(userRepository.save(user));
//    }
//    @PutMapping("users/{id}")
//    public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User user){
//        if (!userRepository.existsById(id)) return ResponseEntity.notFound().build();
//        return ResponseEntity.ok(userRepository.save(user));
//    }

//}
