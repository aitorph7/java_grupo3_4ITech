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

    private Double rating;
    private String opinion;

    //un usuario muchos comentarios (bloquear muchos comentarios en una misma charla)
    @ManyToOne
    @JoinColumn(name ="user_id", foreignKey = @ForeignKey(name = "fk_user_comment"))
    private User user;


    //una charla multiples comentarios
    // @ManyToOne
    // @JoinColumn(name = "keynote_id")
    // @ToString.Exclude
    // private Keynote keynote;
}
