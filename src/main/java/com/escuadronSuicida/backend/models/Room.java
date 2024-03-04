package com.escuadronSuicida.backend.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "rooms")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer capacity;
    private Boolean hasSockets;

    // @OneToMany con Keynotes
    @OneToMany
    @ToString.Exclude // para evitar errores con el fetching LAZY de objetos.
    private List<Keynote> keynotes;
}