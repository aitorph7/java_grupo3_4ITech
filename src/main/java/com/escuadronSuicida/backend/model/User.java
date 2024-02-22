package com.escuadronSuicida.backend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    @JsonIgnore // no muestra el dato sensible 'password' en las respuestas JSON.
    private String password;
    private String address; /* No creo otra entidad Address, solo relleno este
    atributo con la dirección completa
    */
    private UserRole userRole;
}
