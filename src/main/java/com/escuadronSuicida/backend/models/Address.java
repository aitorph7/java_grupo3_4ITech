package com.escuadronSuicida.backend.models;

import jakarta.persistence.*;
import lombok.*;

//@AllArgsConstructor
//@NoArgsConstructor
//@Getter
//@Setter
//@ToString

@Entity
@Table(name = "addresses")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String street;
    private Long number;
    private String city;
    private Long postalCode;

}
