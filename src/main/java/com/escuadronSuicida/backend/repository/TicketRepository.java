package com.escuadronSuicida.backend.repository;

import com.escuadronSuicida.backend.models.Ticket;

import java.util.List;

public interface TicketRepository {
    void saveAll(List<Ticket> tickets);
}
