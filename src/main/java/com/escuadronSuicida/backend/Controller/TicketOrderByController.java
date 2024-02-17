package com.escuadronSuicida.backend.Controller;

import com.escuadronSuicida.backend.repository.TicketOrderBuyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("ticket-order-buy")
public class TicketOrderByController {

    private final TicketOrderBuyRepository ticketOrderBuyRepository;

    @Autowired
    public TicketOrderByController(TicketOrderBuyRepository ticketOrderBuyRepository) {
        this.ticketOrderBuyRepository = ticketOrderBuyRepository;
    }
    // Aquí puedes agregar tus métodos relacionados con el controlador
}
