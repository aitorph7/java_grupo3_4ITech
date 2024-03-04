package com.escuadronSuicida.backend.models;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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

    @Column(nullable = false, length =100 )
    private String name;

    private LocalDateTime startDate; // fecha y hora de inicio, ojo devuelve un string

    private LocalDateTime endDate; // fecha y hora de fin

    // @OneToMany
    // @JoinColumn(name = "track_id")
    // @ToString.Exclude
    //private Track track;  ojo!! aquí era un fallo Alan..asociacion en la misma clase NO TIENE SENTIDO

    //@OneToMany(mappedBy = "track") //, cascade = CascadeType.ALL)
    //List<Keynote> keynoteList = new ArrayList<>();  en un futuro a mayores  ??

}

