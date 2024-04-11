package com.escuadronSuicida.backend.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

@Entity
@Table(name ="ticketOrderBuys")
// entidad intermedia entre User y Ticket, refleja la compra de un ticket
public class TicketOrderBuy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate startDate;

    private LocalDate finishDate;

    private Double discount;

    private Double totalPrice;

    private Integer quantity; // comparar este dato a Ticket maxNum

    private String paymentMethod;

    private String channel; // canal de compra: ONLINE, OFFLINE

    private String qrUrl; // Código QR

    // Many To One // no puede comprar mas capar en frontend
    @ManyToOne
    private User user;

    // Many To One varias compras de mismo ticket  many to one permite
    @ManyToOne
    private Ticket ticket;

}
