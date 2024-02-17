package com.escuadronSuicida.backend.models;

import java.time.LocalDateTime;

// entidad intermedia entre User y Ticket, refleja la compra de un ticket
public class TicketOrderBuy {

    private Long id;

    private LocalDateTime date;

    private Double discount;

    private Double totalPrice;

    private Integer quantity; // comparar este dato a Ticket maxNum

    private String paymentMethod;

    private String channel; // canal de compra: ONLINE, OFFLINE

    private String qrUrl; // Código QR

    // Many To One
    private User user;

    // Many To One
    private Ticket ticket;


}
