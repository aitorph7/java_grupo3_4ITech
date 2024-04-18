package com.escuadronSuicida.backend.services;


import com.escuadronSuicida.backend.models.Ticket;
import com.escuadronSuicida.backend.repository.TicketRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;


@Service
public class TicketServiceImpl implements TicketService{

    private final TicketRepository ticketRepository;

    public TicketServiceImpl(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    @Override
    public List<Ticket> findTicket() {
        return ticketRepository.findAll();

    }

    @Override
    public Ticket findById(Long id) {
        return ticketRepository.findById(id).orElseThrow();
    }

    @Override
    public Ticket createTicket(Ticket ticket) {
        Logger logger = LoggerFactory.getLogger(Ticket.class);
        try {
            return ticketRepository.save(ticket);
        } catch (Exception e) {
            // Registrar el error
            logger.error("Hubo un error al crear el Ticket", e);

            // Lanzar una nueva excepción
            throw new RuntimeException("Hubo un error al crear el Ticket: " + e.getMessage(), e);
        }
    }

    @Override
    public Ticket updateTicket(Long id, Ticket ticket) {
        Optional<Ticket> ticketOptional = ticketRepository.findById(id);
        if (ticketOptional.isPresent()) {
            Ticket ticketFromDatabase = ticketOptional.get();
            ticketFromDatabase.setTitle(ticket.getTitle());
            ticketFromDatabase.setPrice(ticket.getPrice());
            ticketFromDatabase.setMaxNum(ticket.getMaxNum());
            return ticketRepository.save(ticketFromDatabase);

            // esto es actualizar solo esos atributos como sea necesario, aunque en este caso son todos.
        } else {
            return null;
        }
    }

    @Override
    public boolean deleteTicket(Long id) {
        Optional<Ticket> ticketOptional = ticketRepository.findById(id);
        if (ticketOptional.isPresent()) {
            ticketRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}


