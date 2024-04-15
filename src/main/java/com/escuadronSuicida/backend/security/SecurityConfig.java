package com.escuadronSuicida.backend.security;

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
<<<<<<< HEAD
                .requestMatchers("/**").permitAll()
=======
                .requestMatchers("home").permitAll() // Permitimos ver la página home a cualquier usuario no logado
>>>>>>> 6e7a662723e2085c99b5a32901582d4a4efb6eba
                // lo que no sea login o register es obligatorio estar autenticado
                .requestMatchers(HttpMethod.POST, "keynotes").hasAnyAuthority("ADMIN") // solo el ADMIN puede crear keynotes
                .requestMatchers(HttpMethod.PUT, "keynotes").hasAnyAuthority("ADMIN") // solo el ADMIN actualizar ver keynotes
                .requestMatchers(HttpMethod.DELETE, "keynotes").hasAnyAuthority("ADMIN") // solo el ADMIN puede borrar keynotes
                // .requestMatchers(HttpMethod.POST,"").hasAnyAuthority("ADMIN")
                // .requestMatchers(HttpMethod.POST, "admin/**").hasAnyAuthority("ADMIN")
                .requestMatchers(HttpMethod.POST, "tickets").hasAnyAuthority("USER") // USER y ADMIN pueden crear tickets
                .requestMatchers(HttpMethod.PUT, "tickets").hasAnyAuthority("ADMIN") // solo el ADMIN actualizar ver tickets
                .requestMatchers(HttpMethod.DELETE, "tickets").hasAnyAuthority("ADMIN") // solo el ADMIN puede borrar tickets
                .requestMatchers(HttpMethod.POST, "comments").hasAnyAuthority("USER") // USER y ADMIN pueden crear tickets
                .requestMatchers(HttpMethod.PUT, "comments").hasAnyAuthority("USER")
                .requestMatchers(HttpMethod.DELETE, "comments").hasAnyAuthority("ADMIN")
                .requestMatchers(HttpMethod.POST, "tracks").hasAnyAuthority("ADMIN")
                .requestMatchers(HttpMethod.PUT, "tracks").hasAnyAuthority("ADMIN")
                .requestMatchers(HttpMethod.DELETE, "tracks").hasAnyAuthority("ADMIN")
                .requestMatchers(HttpMethod.POST, "users").hasAnyAuthority("USER","ADMIN")
                .requestMatchers(HttpMethod.PUT, "users").hasAnyAuthority("USER", "ADMIN")
                .requestMatchers(HttpMethod.DELETE, "users").hasAnyAuthority("ADMIN")
                .requestMatchers(HttpMethod.POST, "rooms").hasAnyAuthority("ADMIN")
                .requestMatchers(HttpMethod.PUT, "rooms").hasAnyAuthority("ADMIN")
                .requestMatchers(HttpMethod.DELETE, "rooms").hasAnyAuthority("ADMIN")
                .requestMatchers(HttpMethod.POST, "ticketOrderBuy").hasAnyAuthority("ADMIN", "USER")
                .requestMatchers(HttpMethod.PUT, "ticketOrderBuy").hasAnyAuthority("ADMIN", "USER")
                .anyRequest()
                .authenticated();

        // Asignar nuesro filtro personalizado de JWT
        http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}
