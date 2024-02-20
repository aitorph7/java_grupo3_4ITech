package com.escuadronSuicida.backend.models;

import jakarta.persistence.*;
import lombok.*;

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

    private LocalDateTime date;

    private Double discount;

    private Double totalPrice;

    private Integer quantity; // comparar este dato a Ticket maxNum

    private String paymentMethod;

    @OneToOne
    private Ticket ticket;


}
