package com.escuadronSuicida.backend.security;

import com.escuadronSuicida.backend.models.User;
import com.escuadronSuicida.backend.models.UserRole;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

public class SecurityUtils {

    private SecurityUtils() {}
     // prohíbo crear objetos de la clase SecurityUtils.

    /**
     * Devuelve el usuario autenticado extraído de Spring Security
     * Se utiliza así:
     * *
     * * User user = SecurityUtils.getCurrentUser().orElseThrow();
     *
     * @return
     */
    public static Optional<User> getCurrentUser() {


        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof User user) {
            return Optional.of(user);
        } else {
            return Optional.empty();
        }

    }
        public static boolean isAdminCurrentUser() {
            if (getCurrentUser().isEmpty()) {
                return false;
            }
            User user = getCurrentUser().get();
            return user.getUserRole().equals(UserRole.ADMIN);
        }

}
