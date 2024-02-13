package com.escuadronSuicida.backend.services;

import com.escuadronSuicida.backend.models.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketService extends JpaRepository<Ticket, Long> {

}