package com.escuadronSuicida.backend.security;

import com.escuadronSuicida.backend.models.User;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

public class SecurityUtils {

    /**
     * Devuelve el usuario autenticado extraído de Spring Security
     * @return
     */
    public Optional<User> getCurrentUser() {


        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof User user ) {
            return Optional.of(user);
        } else {
            return Optional.empty();
        }
    }
}
