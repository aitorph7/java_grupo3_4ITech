package com.escuadronSuicida.backend.security;

import com.escuadronSuicida.backend.models.User;
import com.escuadronSuicida.backend.repository.UserRepository;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

// 1. Interceptar las peticiones HTTP entrantes
// 2. extraer el token JWC de las cabeceras
// 3. verificar que el token es correcto
// 4. extraer el usuario del token

@Component
@AllArgsConstructor
@Slf4j
public class RequestJWTFilter extends OncePerRequestFilter {


    private final UserRepository userRepository;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        log.info("Hola ejecutando filtro para JWT");
        // Extraer de la cabecera Authorization de la request.

        String bearerToken = request.getHeader("Authorization");
        String token = "";
        if (StringUtils.hasLength(bearerToken) && bearerToken.startsWith("Bearer")) {
            token = bearerToken.substring("Bearer ".length());
        } else {
            filterChain.doFilter(request, response);
            return;
        }
        log.info("Extraido token JWT {}", token);

        // Verificar el token JWT
        byte[] key = Base64.getDecoder().decode("FZD5maIaX04mYCwsgckoBh1NJp6T3t62h2MVyEtdo3w=");
        String userId = Jwts.parser()
                .verifyWith(Keys.hmacShaKeyFor(key))
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .getSubject();

        log.info("Id de usuario {} ", userId);

        // 3. Obetener el usuario de base de datos cuyo id hemos extraído del token JWT
        Optional<User> userOptional = this.userRepository.findById(Long.valueOf(userId));
        if (userOptional.isEmpty()) {
            // no hay usuario, devolver error Unauthorized 401
            log.warn("Usuario con id {} no encontrado", userId);
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
        }
        // 4. Crear objeto autenticación con datos del usuario y guardarlo en el contexto de seguridad de Spring security
        // OBLIATORIO: tener el starter Spring security en el pom.xml
        User user = userOptional.get();
        log.info("Role del usuario {}", user.getUserRole().toString());
        SimpleGrantedAuthority role = new SimpleGrantedAuthority(user.getUserRole().name()); // o también podemos pasar de enum a String con el método toString además del método name()
        Authentication auth = new UsernamePasswordAuthenticationToken(user, null, List.of(role));
        SecurityContextHolder.getContext().setAuthentication(auth);

        // Dejar pasar a la petición para que continúe
        filterChain.doFilter(request, response);
    }
}
