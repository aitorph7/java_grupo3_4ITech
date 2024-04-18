package com.escuadronSuicida.backend.services;

import com.escuadronSuicida.backend.models.Ticket;
import com.escuadronSuicida.backend.models.TicketOrderBuy;
import com.escuadronSuicida.backend.repository.TicketOrderBuyRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class TicketOrderBuyServiceImpl implements TicketOrderBuyService {

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
        return ticketOrderBuyRepository.findById(id).orElseThrow();
    }

    @Override
    public TicketOrderBuy createTicketOrderBuy(TicketOrderBuy ticketOrderBuy) {
        Logger logger = LoggerFactory.getLogger(Ticket.class);
        try {
            return ticketOrderBuyRepository.save(ticketOrderBuy);
        } catch (Exception e) {
            // Registrar el error
            logger.error("Hubo un error al crear el Ticket", e);

            // Lanzar una nueva excepción
            throw new RuntimeException("Hubo un error al crear el Ticket: " + e.getMessage(), e);
        }
    }

    @Override
    public TicketOrderBuy updateTicketOrderBuy(Long id, TicketOrderBuy ticketOrderBuy) {
        Optional<TicketOrderBuy> ticketOrderBuyOptional = ticketOrderBuyRepository.findById(id);
        if (ticketOrderBuyOptional.isPresent()) {
            TicketOrderBuy ticketOrderBuyFromDatabase = ticketOrderBuyOptional.get();
            ticketOrderBuyFromDatabase.setStartDate(ticketOrderBuy.getStartDate());
            ticketOrderBuyFromDatabase.setFinishDate(ticketOrderBuy.getFinishDate());
            ticketOrderBuyFromDatabase.setDiscount(ticketOrderBuy.getDiscount());
            ticketOrderBuyFromDatabase.setTotalPrice(ticketOrderBuy.getTotalPrice());
            ticketOrderBuyFromDatabase.setQuantity(ticketOrderBuy.getQuantity());
            ticketOrderBuyFromDatabase.setPaymentMethod(ticketOrderBuy.getPaymentMethod());
            ticketOrderBuyFromDatabase.setChannel(ticketOrderBuy.getChannel());
            ticketOrderBuyFromDatabase.setQrUrl(ticketOrderBuy.getQrUrl());
            return ticketOrderBuyRepository.save(ticketOrderBuyFromDatabase);

            // esto es actualizar solo esos atributos como sea necesario, aunque en este caso son todos.
        } else {
            return null;
        }
    }



    @Override
    public boolean deleteTicketOrderBuy(Long id) {
        Optional<TicketOrderBuy> ticketOrderBuyOptional = ticketOrderBuyRepository.findById(id);
        if (ticketOrderBuyOptional.isPresent()) {
            ticketOrderBuyRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}




