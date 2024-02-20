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

     @ManyToOne
    // @JoinColumn(name ="user_id")
    private User user;

    @ManyToOne
   // @JoinColumn(name = "keynote_id")
   // @ToString.Exclude
    private Keynote keynote;
}
