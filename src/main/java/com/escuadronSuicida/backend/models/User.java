package com.escuadronSuicida.backend.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity /* Esta clase es una entidad y debe ser mapeada a una tabla
en la BD.
*/
@Table(name = "users") // desde JPA tb, aunque opcional; la añado para verla.
public class User {
    @Id // Especifica la clave primaria de esta entidad.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;

    @Column(unique = true) // el email de cada usuario debe ser único.
    private String email;
    private String phone;

    @Column(unique = true) // el nombre de usuario de cada User también debe ser único.
    private String userName;

    @JsonIgnore // no muestra el dato sensible 'password' en las respuestas JSON.
    private String password;

    private String address; /* No creo otra entidad Address, solo relleno este
    atributo con la dirección completa con formato:
    calle/número/código postal/ciudad/provincia.
    */

    @Enumerated(EnumType.STRING)
    private UserRole userRole;

    @OneToMany(mappedBy = "opinion", cascade = CascadeType.ALL)
    private List<Comment> comments;
}
