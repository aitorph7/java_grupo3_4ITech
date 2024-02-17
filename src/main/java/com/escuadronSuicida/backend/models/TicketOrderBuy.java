package com.escuadronSuicida.backend.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table (name ="ticketOrderBuy")

public class TicketOrderBuy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime date;

    private Double discount;

    private Double totalPrice;

    private Integer quantity;

    private String paymentMethod;

    private String channel; // canal de compra: ONLINE, OFFLINE

    private String qrUrl; // Código QR



    // Getters y setter

    // No necesitas definir los getters y setters cuando usas Lombok
}
