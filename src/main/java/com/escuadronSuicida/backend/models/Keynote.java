package com.escuadronSuicida.backend.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

@Entity
@Table(name = "keynotes")

public class Keynote {  // Charla

    // atributos básicos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String summary;  // sumary or descriptionShort
    private String description; // description or descriptionLong
    private String webinarUrl; // video youtube, zoom,
    private Integer numRoom; // numero de sala
    private Integer maxNumPersons; // aforo maximo - permitido un contador*
    private DifficultyLevel level;
    // Opción 1:
    // private Duration duration;
    // Opción 2:
    private Integer durationInMin;


    // Asociaciones: un solo speaker en cada charla
    @ManyToOne
    // @JoinColumn(name = "speaker_id")
    private User speaker; // Many to One

    @ManyToOne
    // @JoinColumn(name = "track_id") varias charlas en simultaneo
    private Track track; // Many To One

    //se refiere a cuantas charlas puedes ir ( no quiere decir en simultaneo)
    @ManyToMany
    private List<User> attendees = new ArrayList<>(); // Many To Many
}
