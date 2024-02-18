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
    private Integer maxNumPersons; // aforo maximo permitido
    private DifficultyLevel level;
    // Opción 1:
    // private Duration duration;
    // Opción 2:
    private Integer durationInMin;

    // Asociaciones:
    @ManyToOne
    @JoinColumn(name = "speaker_id")
    private User speaker; // Many to One
    @ManyToOne
    @JoinColumn(name = "track_id")
    private Track track; // Many To One

    private List<User> attendees = new ArrayList<>(); // Many To Many
}
