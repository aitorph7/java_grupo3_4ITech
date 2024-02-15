package com.escuadronSuicida.backend.services;

import com.escuadronSuicida.backend.models.TicketOrderBuy;

import java.time.LocalDateTime;

public interface TickectOrderBuyService {


        void registrarCompra(Long orderId, LocalDateTime fecha, Double descuento, Double precioTotal,
                             Integer cantidad, String metodoPago);

        Double calcularPrecioTotal(Long orderId);

        void buyTicket(Long ticketId);

        void cancelarCompra(Long orderId);






    }




