package com.escuadronSuicida.backend.services;

import com.escuadronSuicida.backend.models.TicketOrderBuy;
import com.escuadronSuicida.backend.repository.TicketOrderBuyRepository;


import java.util.List;

public class TicketOrderBuyServiceImpl implements TicketOrderBuyService{

    private TicketOrderBuyRepository ticketOrderBuyRepository;
    public TicketOrderBuyServiceImpl(TicketOrderBuyRepository ticketOrderBuyRepository) {
        this.ticketOrderBuyRepository =ticketOrderBuyRepository;
    }

    @Override
    public List<TicketOrderBuy> findTicketOrderBuy() {
        return null;
    }

    @Override
    public TicketOrderBuy findById(Long id) {
        return null;
    }


}
