package com.escuadronSuicida.backend.services;

import com.escuadronSuicida.backend.models.TicketOrderBuy;
import org.springframework.stereotype.Service;

import java.util.List;


public interface TicketOrderBuyService {
    List<TicketOrderBuy> findTicketOrderBuy();

    TicketOrderBuy findById(Long id);

    TicketOrderBuy createTicketOrderBuy(TicketOrderBuy ticketOrderBuy);

    TicketOrderBuy updateTicketOrderBuy(Long id, TicketOrderBuy ticketOrderBuy);

    boolean deleteTicketOrderBuy(Long id);
}






