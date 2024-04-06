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
@Table(name = "comments")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "valoracion")
    private Integer rating;
    @Column(name="reseña",length = 1000)
    private String opinion;

    private LocalDateTime dateTime;

    //un usuario muchos comentarios (bloquear muchos comentarios en una misma charla)
    @ManyToOne
    @JoinColumn(name ="user_id")
    private User user;


     //una charla multiples comentarios
    @ManyToOne
    @JoinColumn(name = "keynote_id")
    @ToString.Exclude
    private Keynote keynote;
}