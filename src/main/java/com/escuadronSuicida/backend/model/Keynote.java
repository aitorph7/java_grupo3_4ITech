package com.escuadronSuicida.backend.model;

import java.util.ArrayList;
import java.util.List;

// Charla
public class Keynote {

    // atributos básicos
    private Long id;
    private String title;
    private String descriptionShort;  // sumary
    private String descriptionLong; // description
    private String webinarUrl; // video youtube, zoom,
    private Integer numRoom; // numero de sala
    private Integer maxNumPersons; // aforo maximo permitido
    private DifficultyLevel level;
    // Opción 1:
    // private Duration duration;
    // Opción 2:
    private Integer durationInMin;

    // Asociaciones:
    private User speaker; // Many to One
    private Track track; // Many To One
    private List<User> attendees = new ArrayList<>(); // Many To Many
}
