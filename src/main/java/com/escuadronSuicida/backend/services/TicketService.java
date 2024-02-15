package com.escuadronSuicida.backend.services;

import com.escuadronSuicida.backend.models.TicketOrderBuy;

public interface TicketService {

    void crearOrdenCompra(TicketOrderBuy order);


    TicketOrderBuy obtenerOrdenCompraPorId(Long orderId);

    boolean verificarDisponibilidadTickets(TicketOrderBuy order);



    }

