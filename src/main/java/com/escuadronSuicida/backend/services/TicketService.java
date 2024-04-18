package com.escuadronSuicida.backend.services;


import com.escuadronSuicida.backend.models.Ticket;
import org.springframework.stereotype.Service;

import java.util.List;


public interface TicketService {

    List<Ticket> findTicket();
    Ticket findById(Long id);


    Ticket createTicket(Ticket ticket);

    Ticket updateTicket(Long id, Ticket ticket);

    boolean deleteTicket(Long id);
}

