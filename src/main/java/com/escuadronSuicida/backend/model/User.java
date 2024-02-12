package com.escuadronSuicida.backend.model;



import java.util.ArrayList;
import java.util.List;

public class User {

    private Long id;

    private String firstName;
    private String lastName;

    private String email;
    private String password;
    private String phone;

    // Opción 1: Esto puede ser una entidad Role y aquí una asociación oneToMany
    // private List<String> roles = new ArrayList<>();

    // Opción 2: una enum
    // @ElementCollection(fetch = FetchType.EAGER)
    // @Enumerated(EnumType.STRING)
    private UserRole role;

    // Opción 3: una clase
    // private UserRole role;
}
