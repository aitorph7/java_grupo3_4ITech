package com.escuadronSuicida.backend.services;

import com.escuadronSuicida.backend.models.TicketOrderBuy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TicketOrderBuyService {
    List<TicketOrderBuy> findTicketOrderBuy();

    TicketOrderBuy findById(Long id);
}






