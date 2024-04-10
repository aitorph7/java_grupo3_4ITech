package com.escuadronSuicida.backend.Security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig {

    //    Personalizer el objeto HttpSecurity de Spring Scurity para utilizar nuestro filto JWT y proteger controladores

    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        // Sin estados, sin sesiones Http, ya que usamos tokens JWT
        // La autenticación JWT es sin estado y no depende de sesiones o cookies
        http.csrf().disable().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        // Proteger rutas
        http.authorizeHttpRequests()
                .requestMatchers("/users/login").permitAll()
                .requestMatchers("/uers/register").permitAll()
                // lo que no sea login o register es obligatorio estar autenticado
                .anyRequest()
                .authenticated();

        // Asignar nuesro filtro personalizado de JWT
//        http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}
