package com.escuadronSuicida.backend.controller;

import com.escuadronSuicida.backend.dto.Login;
import com.escuadronSuicida.backend.dto.Register;
import com.escuadronSuicida.backend.dto.Token;
import com.escuadronSuicida.backend.exception.UnauthorizedException;
import com.escuadronSuicida.backend.models.Keynote;
import com.escuadronSuicida.backend.models.User;
import com.escuadronSuicida.backend.models.UserRole;
import com.escuadronSuicida.backend.repository.UserRepository;
import com.escuadronSuicida.backend.services.FileService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import com.escuadronSuicida.backend.security.SecurityUtils;

import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

@CrossOrigin("*")
@RestController
@AllArgsConstructor // Para asegurarme de que se hace bien la inyección de dependencias.
@Slf4j
public class UserController {

    private final UserRepository userRepository;
    private final FileService fileService;
    private final PasswordEncoder passwordEncoder;

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

    // permito subir archivos para que el user tenga imagen/avatar
    @PostMapping("users")
    public ResponseEntity<User> create(
            @RequestParam(value = "photo", required = false) MultipartFile file, User user) {

        if (file != null && !file.isEmpty()) {
            String fileName = fileService.store(file);
            user.setPhotoUrl(fileName);
        } else {
            user.setPhotoUrl("avatar.png");
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));

        return ResponseEntity.ok(userRepository.save(user));
    }

    @PutMapping("users/{id}")
    public ResponseEntity<User> update(@RequestParam(value = "photo", required = false) MultipartFile file,
                                       User user,
                                       @PathVariable Long id) {

//        User currentUser = SecurityUtils.getCurrentUser().orElseThrow();
//        // Verificar si el usuario actual tiene permiso para modificar los datos
//        if (currentUser.getId().equals(id) || SecurityUtils.isAdminCurrentUser()){
            if(!this.userRepository.existsById(id))
                return ResponseEntity.notFound().build();

            User userFromDB = this.userRepository.findById(id).orElseThrow();
            userFromDB.setFirstName(user.getFirstName());
            userFromDB.setLastName(user.getLastName());
            userFromDB.setPhone(user.getPhone());
            userFromDB.setUserName((user.getUserName()));
            userFromDB.setAddress(user.getAddress());

            if(SecurityUtils.getCurrentUser().orElseThrow().getUserRole().equals(UserRole.ADMIN)) {
                userFromDB.setEmail(user.getEmail());
                userFromDB.setUserRole((user.getUserRole()));

            }

            if(file != null && !file.isEmpty()) {
                String fileName = fileService.store(file);
                userFromDB.setPhotoUrl(fileName);
            }

            return ResponseEntity.ok(this.userRepository.save(userFromDB));
//        } else {
//            throw new UnauthorizedException("No tiene permiso para modificar este usuario/a.");
//        }
    }

//    @PutMapping("users/{id}")
//    public User update(@PathVariable Long id, @RequestBody User user){
//        User currentUser = SecurityUtils.getCurrentUser().orElseThrow();
//        // Verificar si el usuario actual tiene permiso para modificar los datos
//        if (currentUser.getId().equals(id) || SecurityUtils.isAdminCurrentUser()){
//            Optional<User> userOptional = userRepository.findById(id);
//            if (userOptional.isPresent()){
//                User userFromDB = userOptional.get();
//                userFromDB.setFirstName(user.getFirstName());
//                userFromDB.setLastName(user.getLastName());
//                userFromDB.setEmail(user.getEmail());
//                userFromDB.setPhone(user.getPhone());
//                userFromDB.setUserName(user.getUserName());
//                userFromDB.setPassword(user.getPassword());
//                userFromDB.setAddress(user.getAddress());
//                userFromDB.setUserRole(user.getUserRole());
//                userFromDB.setPhotoUrl(user.getPhotoUrl());
//                // Si se proporciona una nueva contraseña, actualizarla
//                if (user.getPassword() != null && !user.getPassword().isEmpty()){
//                    userFromDB.setPassword(user.getPassword());
//                }
//                //TODO que solo el propio usuario pueda modificar su password.
//                //Guardar los cambios en BD
//                return userRepository.save(userFromDB);
//            } else {
//                throw new NoSuchElementException("Usuario/a no encontrado en Base de Datos.");
//            }
//        } else {
//            throw new UnauthorizedException("No tiene permiso para modificar este usuario/a.");
//        }
//    }
//
//    // Permito actualizar archivo del user (imagen/avatar)
//    @PutMapping("{id}")
//    public ResponseEntity<User> update(@RequestParam(value = "photo", required = false) MultipartFile file,
//                                          User user,
//                                          @PathVariable Long id) {
//        if (!this.userRepository.existsById(id))
//            return ResponseEntity.notFound().build();
//        if (file != null && !file.isEmpty()) {
//            String fileName = fileService.store(file);
//            user.setPhotoUrl(fileName);
//        } else {
//            user.setPhotoUrl("avatar.png");
//        }
//        return ResponseEntity.ok(this.userRepository.save(user));
//    }

    @DeleteMapping("users/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        userRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
//    public void deleteById(@PathVariable Long id){
//        Solo si se es ADMIN puede eliminar.
//        User user = this.userRepository.findById(id).orElseThrow();
//
//        if (user.getUserRole().equals(UserRole.ADMIN)
//        )
//            this.userRepository.deleteById(id);
//        else
//            throw new UnauthorizedException("No tiene permiso para eliminar usuarios/as.");
//    }

    // Añadido por Angel para el registro y login de usuarios

    @PostMapping("users/register")
    public void register(@RequestBody Register register) {
        // Si el email está ocupado no registramos el usuario
        if (this.userRepository.existsByEmail(register.email())){
            throw new BadCredentialsException("Esta dirección de correo ya está en uso.");
        }
        // Crear el objeto User cifrando la contraseña con BCrypt
        User user = User.builder()
                .email(register.email())
                .password(passwordEncoder.encode(register.password()))
                .userRole(UserRole.USER)
                .build();
        // Guardar el objeto user
        this.userRepository.save(user);
    }

    @PostMapping("users/login")
    public Token login(@RequestBody Login login) {

        // Si el email no existe entonces no se hace login
        if (!this.userRepository.existsByEmail(login.email())) {
            throw new NoSuchElementException("Usuario no encontrado.");
        }
        // Recuperar usuario
        User user = this.userRepository.findByEmail(login.email()).orElseThrow();

        // Comparar contraseñas
        boolean correctPassword = passwordEncoder.matches(login.password(), user.getPassword());
        boolean incorrectPassword = !correctPassword;
        if (incorrectPassword){
            throw new BadCredentialsException("Credenciales incorrectas.");
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

    // Get account
    @GetMapping("users/account")
    public User getCurrentUser() {
        return SecurityUtils.getCurrentUser().orElseThrow();
    }

    // Put account
    @PutMapping("users/account")
    public User update(@RequestBody User user) {
        // Si está autenticado, y el usuario autenticado es ADMIN o es el mismo usuario que la variable user
        // entonces actualizar, en caso contrario no actualizamos
        SecurityUtils.getCurrentUser().ifPresent(currentUser -> {
            if (currentUser.getUserRole() == UserRole.ADMIN || Objects.equals(currentUser.getId(), user.getId())) {
                this.userRepository.save(user);
            } else {
                throw new UnauthorizedException("No tiene permiso para actualizar este usuario.");
            }
        });
        return user;
    }

    // subir avatar al perfil del usuario
    @PostMapping("users/account/avatar")
    public User uploadAvatar(
            @RequestParam(value = "photo") MultipartFile file
        ) {
        User user = SecurityUtils.getCurrentUser().orElseThrow();
        // si hay archivo, le guardo ese archivo y devuelvo el user con el 'return' de +abajo
        if (file != null && !file.isEmpty()) {
            String fileName = fileService.store(file);
            user.setPhotoUrl(fileName);
            this.userRepository.save(user);
        }
        return user; // si no hay archivo devuelvo el user tal cual lo tengo.
    }
}
