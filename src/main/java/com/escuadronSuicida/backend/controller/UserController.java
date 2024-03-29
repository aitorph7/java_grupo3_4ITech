package com.escuadronSuicida.backend.controller;

import com.escuadronSuicida.backend.models.User;
import com.escuadronSuicida.backend.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
public class UserController {
    List<User> users;
    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

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
    @PostMapping("users")
    public ResponseEntity<User> create(@RequestBody User user) {
        return ResponseEntity.ok(userRepository.save(user));
    }
    @PutMapping("users/{id}")
    public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User user){
        if (!userRepository.existsById(id)) return ResponseEntity.notFound().build();
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()){
            User userfromDB = userOptional.get();
            userfromDB.setAddress(user.getAddress());
            userfromDB.setPhone(user.getPhone()); // una vez creado el User en BD, permito que pueda modificar su dirección y teléfono.
            userRepository.save(userfromDB);
            return ResponseEntity.ok(userfromDB);
        } else
            return ResponseEntity.notFound().build();
    }
    @DeleteMapping("users/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        userRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
