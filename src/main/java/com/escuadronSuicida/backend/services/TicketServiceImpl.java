package com.escuadronSuicida.backend.services;


import com.escuadronSuicida.backend.models.Ticket;
import com.escuadronSuicida.backend.repository.TicketRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketServiceImpl implements TicketService{

    private TicketRepository ticketRepository;
    public TicketServiceImpl(TicketRepository ticketRepository) {
        this.ticketRepository =ticketRepository;
    }



    @Override
    public List<Ticket> findTicket() {
        return null;
    }

    @Override
    public Ticket findById(Long id) {
        return null;
    }
}
