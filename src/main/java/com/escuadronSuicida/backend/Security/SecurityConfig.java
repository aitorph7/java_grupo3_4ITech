package com.escuadronSuicida.backend.Security;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@AllArgsConstructor
@Configuration
public class SecurityConfig {

    private final RequestJWTFilter jwtFilter;

    // Personalizer el objeto HttpSecurity de Spring Scurity para utilizar nuestro filto JWT y proteger controladores

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        // Para nuevas versiones de Spring > 6.1
//        http
//                .csrf(csrf -> csrf.disable())
//                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
//                .authorizeHttpRequests(authorizeHttpRequests -> authorizeHttpRequests
//                        .requestMatchers("/users/login").permitAll()
//                        .requestMatchers("/users/register").permitAll()
//                        .anyRequest().authenticated()
//                ).addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)
//                .build();

        // Para las versiones anteriores a Spring 6.1
        // Sin estados, sin sesiones Http, ya que usamos tokens JWT
        // La autenticación JWT es sin estado y no depende de sesiones o cookies
        http.csrf().disable().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        // Proteger rutas
        http.authorizeHttpRequests()
                .requestMatchers("users/login").permitAll()
                .requestMatchers("users/register").permitAll()
                // lo que no sea login o register es obligatorio estar autenticado
                // .requestMatchers(HttpMethod.POST,"keynotes").hasAnyAuthority("ADMIN") // solo el ADMIN puede crear keynotes
                .anyRequest()
                .authenticated();

        // Asignar nuesro filtro personalizado de JWT
        http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}
