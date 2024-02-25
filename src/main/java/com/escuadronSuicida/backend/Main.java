package com.escuadronSuicida.backend;

import com.escuadronSuicida.backend.models.Ticket;
import com.escuadronSuicida.backend.models.TicketOrderBuy;
import com.escuadronSuicida.backend.repository.TicketOrderBuyRepository;
import com.escuadronSuicida.backend.repository.TicketRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootApplication
public class Main {


	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Main.class, args);

		TicketRepository ticketRepo = context.getBean(TicketRepository.class);
		TicketOrderBuyRepository ticketOrderBuyRepo = context.getBean(TicketOrderBuyRepository.class);

	/*	Ticket ticket1 = new Ticket(null, "Ticket1", 50.0, 10);
		Ticket ticket2 = new Ticket(null, "Ticket1", 50.0, 10);
		Ticket ticket3 = new Ticket(null, "Ticket1", 50.0, 10);
		ticketRepo.saveAll(List.of(Ticket1, Ticket2, Ticket3));

		TicketOrderBuy ticketOrderBuy1 = new TicketOrderBuy(null, LocalDateTime.now(), 20.0, 50.0,10,"Tarjeta credito","ONLINE","CodigoqrUrl");
		TicketOrderBuy ticketOrderBuy2 = new TicketOrderBuy(null, LocalDateTime.now(), 20.0, 50.0,10,"Tarjeta debito ","OFFLINE","CodigoqrUrl");
		TicketOrderBuy ticketOrderBuy3 = new TicketOrderBuy(null, LocalDateTime.now(), 20.0, 50.0,10,"Tarjeta credito","ONLINE","CodigoqrUrl");
		ticketOrderBuyRepo.saveAll(List.of(TicketOrderBuy1, TicketOrderBuy2, TicketOrderBuy3));*/

	}
}
