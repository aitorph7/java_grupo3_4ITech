package com.escuadronSuicida.backend.Security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Base64;

// 1. Interceptar las peticiones HTTP entrantes
// 2. extraer el token JWC de las cabeceras
// 3. verificar que el token es correcto
// 4. extraer el usuario del token

@Component
@Slf4j
public class RequestJWTFilter extends OncePerRequestFilter {
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

        // Dejar pasar a la petición para que continúe
        filterChain.doFilter(request, response);
    }
}
