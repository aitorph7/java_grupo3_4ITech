package com.escuadronSuicida.backend.models;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;

import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor


@Table (name ="Ticket")


public class Ticket {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private LocalDate fecha;

    private Double price;

    private Integer maxNum; // numero entradas tickets disponibles para vender


    public void sellTicket() {
        if (maxNum > 0) {
            maxNum = 300;
            System.out.println("Ticket comprado correctamente.");
        } else {
            System.out.println("No hay tickets disponibles para comprar.");
        }
    }
}
