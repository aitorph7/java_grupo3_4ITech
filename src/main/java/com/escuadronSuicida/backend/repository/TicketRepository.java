package com.escuadronSuicida.backend.repository;

import com.escuadronSuicida.backend.models.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
}