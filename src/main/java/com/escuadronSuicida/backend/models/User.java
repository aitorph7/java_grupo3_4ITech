package com.escuadronSuicida.backend.models;


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
//    @JsonIgnore
    private String password;
    private String phone;
    private String address;

    // Opción 1: Esto puede ser una entidad Role y aquí una asociación oneToMany
    // private List<String> roles = new ArrayList<>();

    // Opción 2: una enum
    // @ElementCollection(fetch = FetchType.EAGER)
     @Enumerated(EnumType.STRING)
    private UserRole role;

    // Opción 3: una clase
    // private UserRole role;
}
