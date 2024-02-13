package com.escuadronSuicida.backend.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;


    @Entity
    public class Ticket {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)

        private Long id;

        private String title;

        private LocalDate fecha;

        private Double price;

        private Integer maxNum; // numero entradas tickets disponibles para vender


        @Entity
        public class CodigoDescuento {
            @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)
            private Long id;

            private String codigo;
            private double descuento;

        }

    }
