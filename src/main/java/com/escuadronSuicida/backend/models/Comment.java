package com.escuadronSuicida.backend.models;

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
    @Column(name = "valoracion", precision = 5)
    private Double rating;
    @Column(name="reseña",length = 1500)
    private String opinion;

    //un usuario muchos comentarios (bloquear muchos comentarios en una misma charla)
    @ManyToOne
    @JoinColumn(name ="user_id")
    private User user;


     //una charla multiples comentarios
    @ManyToOne
    @JoinColumn(name = "keynote_id")
   // @ToString.Exclude
    private Keynote keynote;
}
