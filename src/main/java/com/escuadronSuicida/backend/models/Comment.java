package com.escuadronSuicida.backend.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

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
    private Double rating;
    @Column(name="reseña",length = 2000)
    private String opinion;

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
