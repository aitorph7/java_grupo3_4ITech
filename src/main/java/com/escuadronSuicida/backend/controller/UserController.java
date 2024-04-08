package com.escuadronSuicida.backend.controller;

import com.escuadronSuicida.backend.dto.Login;
import com.escuadronSuicida.backend.dto.Register;
import com.escuadronSuicida.backend.dto.Token;
import com.escuadronSuicida.backend.models.User;
import com.escuadronSuicida.backend.models.UserRole;
import com.escuadronSuicida.backend.repository.UserRepository;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.concurrent.TimeUnit;

@CrossOrigin("*")
@RestController
@Slf4j
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
            userfromDB.setPhone(user.getPhone()); // una vez creado el User en BD, permito que solo pueda modificar
            // su dirección y teléfono.
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

    // Añadido por Angel para el registro y login de usuarios

    @PostMapping("users/register")
    public void register(@RequestBody Register register) {
        // Si el email está ocupado no registramos el usuario
        if (this.userRepository.existsByEmail(register.email())){
            throw new RuntimeException("Email ocupado");
        }

        // Crear el objeto User
        // TODO cifrar la contraseña con BCrypt
        User user = new User(null, null, null, register.email(), null, null, register.password(), null, UserRole.USER);

        // Guardar el objeto user
        this.userRepository.save(user);
    }

    @PostMapping("users/login")
    public Token login(@RequestBody Login login) {

        // Si el email no existe entonces no se hace login
        if (!this.userRepository.existsByEmail(login.email())) {
            throw new NoSuchElementException("User not found");
      }

//        // Recuperar usuario
        User user = this.userRepository.findByEmail(login.email()).orElseThrow();

        // Comparar contraseñas
        // TODO cuando la contraseña esté cifrada cambiar el proceso de comparación
        if (!user.getPassword().equals(login.password())){
            throw new RuntimeException("Credenciales incorrectas");
        }

        // JWT Json Web Token: jwt.io
        // Generar token de acceso: eyJhbGciOiJIUzI1NiIsIn......
        // Generar el token: https://github.com/jwtk/jjwt?tab=readme-ov-file#creating-a-jwt
        Date issuedDate = new Date();
        long nextWeekMillis = TimeUnit.DAYS.toMillis(7);
        Date expirationDate = new Date(issuedDate.getTime() + nextWeekMillis);
        byte[] key = Base64.getDecoder().decode("FZD5maIaX04mYCwsgckoBh1NJp6T3t62h2MVyEtdo3w=");

        String token = Jwts.builder()
                // id del usuario
                .subject(String.valueOf(user.getId()))
                // La clave secreta para firmar el token y saber que es nuestro cuando lleguen las peticiones del frontend
                .signWith(Keys.hmacShaKeyFor(key))
                // Fecha emisión del token
                .issuedAt(issuedDate)
                // Fecha de expiración del token
                .expiration(expirationDate)
                // información personalizada: rol, username, email, avatar
                .claim("role", user.getUserRole())
                .claim("email", user.getEmail())
                // claim("avatar", user.getAvatarUrl())
                // Construye el token
                .compact();

        return new Token(token);
    }
}
