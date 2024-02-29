package com.escuadronSuicida.backend.repository;

import com.escuadronSuicida.backend.models.TicketOrderBuy;

import java.util.List;

public interface TicketOrderBuyRepository {
    void saveAll(List<TicketOrderBuy> ticketOrderBuys);
}
