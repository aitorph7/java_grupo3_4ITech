package com.escuadronSuicida.backend.services;

import com.escuadronSuicida.backend.models.Keynote;
import com.escuadronSuicida.backend.models.TicketOrderBuy;
import com.escuadronSuicida.backend.repository.TicketOrderBuyRepository;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class TicketOrderBuyServiceImpl implements TicketOrderBuyService{

    private TicketOrderBuyRepository ticketOrderBuyRepository;
    public TicketOrderBuyServiceImpl(TicketOrderBuyRepository ticketOrderBuyRepository) {
        this.ticketOrderBuyRepository =ticketOrderBuyRepository;
    }

    @Override
    public List<TicketOrderBuy> findTicketOrderBuy() {
        return ticketOrderBuyRepository.findAll();

    }

    @Override
    public TicketOrderBuy findById(Long id) {
        return ticketOrderBuyRepository.findById(id).get();
    }

}
