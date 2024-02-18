package com.escuadronSuicida.backend.models;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

@Entity
@Table( name = "tracks")
public class Track {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, length =50 )
    private String name;

    private LocalDateTime startDate; // fecha y hora de inicio

    private LocalDateTime endDate; // fecha y hora de fin


    // @OneToMany
    // @JoinColumn(name = "track_id")
    // @ToString.Exclude
    private Track track;

}

