package com.escuadronSuicida.backend.security;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@AllArgsConstructor
@Configuration
public class SecurityConfig {

    private final RequestJWTFilter jwtFilter;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    // Personalizar el objeto HttpSecurity de Spring Security para utilizar nuestro filtro JWT y proteger controladores

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        // Para nuevas versiones de Spring >= 6.1:
//        @Bean
//        public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//             return http
//                .csrf(csrf -> csrf.disable())
//                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
//                .authorizeHttpRequests(authorizeHttpRequests -> authorizeHttpRequests
//                        .requestMatchers("/users/login").permitAll()
//                        .requestMatchers("/users/register").permitAll()
//                        .anyRequest().authenticated()
//                ).addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)
//                .build();
//          }

        // Para las versiones anteriores a Spring 6.1
        // Sin estados, sin sesiones Http, ya que usamos tokens JWT
        // La autenticación JWT es sin estado y no depende de sesiones o cookies
        http.csrf().disable().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        // Proteger rutas: IMPORTANTE, no colocar una '/' delante de la ruta
        // ❌ /users/login
        // ✅ users/login
        http.authorizeHttpRequests()
                .requestMatchers("users/login").permitAll()
                .requestMatchers("users/register").permitAll()
                .requestMatchers("files/**").permitAll()
                .requestMatchers("keynotes/projections/home").permitAll()
                .requestMatchers(HttpMethod.GET, "comments").permitAll()
                .requestMatchers(HttpMethod.GET, "keynotes").permitAll()
                .requestMatchers(HttpMethod.GET, "keynotes/*/detail").permitAll()
//                .requestMatchers("/**").permitAll()
                .requestMatchers("home").permitAll() // Permitimos ver la página 'home' a cualquier usuario no logado
                // lo que no sea login o register es obligatorio estar autenticado
                .requestMatchers(HttpMethod.POST, "keynotes").hasAnyAuthority("ADMIN") // solo el ADMIN puede crear keynotes
                .requestMatchers(HttpMethod.PUT, "keynotes").hasAnyAuthority("ADMIN") // solo el ADMIN actualizar keynotes
                .requestMatchers(HttpMethod.DELETE, "keynotes").hasAnyAuthority("ADMIN") // solo el ADMIN puede borrar keynotes
                .requestMatchers(HttpMethod.POST, "tickets").hasAnyAuthority("ADMIN") // USER y ADMIN pueden crear tickets
                .requestMatchers(HttpMethod.PUT, "tickets").hasAnyAuthority("ADMIN") // solo el ADMIN actualizar tickets
                .requestMatchers(HttpMethod.DELETE, "tickets").hasAnyAuthority("ADMIN") // solo el ADMIN puede borrar tickets
                .requestMatchers(HttpMethod.POST, "comments").permitAll()
                .requestMatchers(HttpMethod.PUT, "comments").permitAll()
                .requestMatchers(HttpMethod.DELETE, "comments").hasAnyAuthority("ADMIN", "USER")
                .requestMatchers(HttpMethod.POST, "tracks").hasAnyAuthority("ADMIN")
                .requestMatchers(HttpMethod.PUT, "tracks").hasAnyAuthority("ADMIN")
                .requestMatchers(HttpMethod.DELETE, "tracks").hasAnyAuthority("ADMIN")
                .requestMatchers(HttpMethod.POST, "users").hasAnyAuthority("USER", "ADMIN")
                .requestMatchers(HttpMethod.PUT, "users").hasAnyAuthority("USER", "ADMIN")
                .requestMatchers(HttpMethod.DELETE, "users").hasAnyAuthority("ADMIN") // TODO: ¿Un usuario podría borrar su propia cuenta?
                .requestMatchers(HttpMethod.POST, "rooms").hasAnyAuthority("ADMIN")
                .requestMatchers(HttpMethod.PUT, "rooms").hasAnyAuthority("ADMIN")
                .requestMatchers(HttpMethod.DELETE, "rooms").hasAnyAuthority("ADMIN")
                .requestMatchers(HttpMethod.POST, "ticketOrderBuy").permitAll()
                .requestMatchers(HttpMethod.PUT, "ticketOrderBuy").hasAnyAuthority("ADMIN")
                .requestMatchers(HttpMethod.DELETE, "ticketOrderBuy").hasAnyAuthority("ADMIN")
                .anyRequest()
                .authenticated();

        // Asignar nuestro filtro personalizado de JWT
        http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}
