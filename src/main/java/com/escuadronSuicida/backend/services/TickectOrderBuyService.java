package com.escuadronSuicida.backend.services;

import com.escuadronSuicida.backend.models.Ticket;
import com.escuadronSuicida.backend.models.TicketOrderBuy;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface TickectOrderBuyService {

    List<TicketOrderBuy> findTicketOrderBuy();

    Ticket findByID(Long id);

}




