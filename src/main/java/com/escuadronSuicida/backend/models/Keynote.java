package com.escuadronSuicida.backend.models;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.mapping.ToOne;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity /* Esta clase es una entidad y debe ser mapeada a una
tabla en la BD. */
@Table(name = "keynotes")
public class Keynote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String summary;  // sumary or descriptionShort

    @Column(length = 2500) // ampliar la longitud de 255 a 2500
    private String description; // description or descriptionLong

    private String webinarUrl; // video youtube, zoom,
    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room; // numero de sala
    private Long maxNumPersons; // aforo maximo - permitido un contador*

    @Enumerated(EnumType.STRING)
    private DifficultyLevel difficultyLevel;
    private Integer durationInMin;

    @ManyToOne // Varias keynotes pueden tener un mismo Speaker.
    @JoinColumn(name = "speaker_id")
    private User speaker;

    @ManyToOne
    // @JoinColumn(name = "track_id") varias charlas en simultaneo
    private Track tracks; // Many To One

    //se refiere a cuantas charlas puedes ir ( no quiere decir en simultaneo)
    @ManyToMany
    @ToString.Exclude
    private List<User> attendees = new ArrayList<>(); // Many To Many
}
