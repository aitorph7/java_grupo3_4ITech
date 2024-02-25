package com.escuadronSuicida.backend.services;


import com.escuadronSuicida.backend.models.Ticket;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TicketService {

    List<Ticket> findTicket();
    Ticket findById(Long id);



}

