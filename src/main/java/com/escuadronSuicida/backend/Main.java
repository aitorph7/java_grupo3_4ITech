package com.escuadronSuicida.backend;

import com.escuadronSuicida.backend.models.*;
import com.escuadronSuicida.backend.repository.TicketOrderBuyRepository;
import com.escuadronSuicida.backend.repository.TicketRepository;
import com.escuadronSuicida.backend.repository.TrackRepository;
import com.escuadronSuicida.backend.repository.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootApplication
public class Main {


	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Main.class, args);

		UserRepository userRepository = context.getBean(UserRepository.class);
		RoomRepository roomRepository = context.getBean(RoomRepository.class);
		TrackRepository trackRepository = context.getBean(TrackRepository.class);
		TicketRepository ticketRepo = context.getBean(TicketRepository.class);
		TicketOrderBuyRepository ticketOrderBuyRepository = context.getBean(TicketOrderBuyRepository.class);

		User user1 = new User(null,
				"Pablo",
				"González",
				"pablo@gmail.com",
				"657478901",
				"pablou1",
				"pablou1",
				"callePablo, 2, 28046, Madrid, Madrid",
				UserRole.ATTENDEE
		);
		User user2 = new User(null,
				"Oscar",
				"Catalan",
				"oscar@yahoo.es",
				"663501200",
				"oscaru2",
				"oscaru2",
				"calleOscar, 46, 28011, Madrid, Madrid",
				UserRole.ATTENDEE
		);
		User user3 = new User(null,
				"Trevor",
				"McIntosh",
				"trevor@apple.com",
				"+1 415-555-1234",
				"trevor@apple.com",
				"trevoru3",
				"1234 TrevorSt, San Francisco, CA 94123, USA",
				UserRole.SPEAKER
		);
		User user4 = new User(null,
				"Eutimio",
				"Developer",
				"eutimio@certidevs.com",
				"619567144",
				"eutimmiou4",
				"eutimmiou4",
				"calleEutimio, 23, 28004, Madrid, Madrid",
				UserRole.ADMIN
		);
		User user5 = new User(null,
				"Leocadia",
				"Sigüenza",
				"leocadia@hotmail.com",
				"661541094",
				"leocadiau5",
				"leocadiu5",
				"calleLeocadia, 10, 02001, Albacete, Albacete",
				UserRole.ATTENDEE
		);
		userRepository.saveAll(List.of(user1, user2, user3, user4, user5));

		Room room1 = new Room(null, "Innovation Tech Hall", 500, Boolean.FALSE, null);
		Room room2 = new Room(null, "ByteSphere Convergence Hall", 350, Boolean.FALSE, null);
		Room room3 = new Room(null, "Quantum Nexus Summit Arena", 200, Boolean.TRUE, null);
		Room room4 = new Room(null, "NanoVerse Discovery Pavilion", 400, Boolean.FALSE, null);
		Room room5 = new Room(null, "TechHorizon Visionarium", 350, Boolean.FALSE, null);
		roomRepository.saveAll(List.of(room1, room2, room3, room4, room5));

		Track tr1 = new Track(1L,"Track 1", LocalDateTime.of(2024,5,29,9,0), LocalDateTime.of(2024,5,29,10,0));
		Track tr2 = new Track(2L,"Track 2", LocalDateTime.of(2024,5,29,10,0), LocalDateTime.of(2024,5,29,11,0));
		Track tr3 = new Track(3L,"Track 3", LocalDateTime.of(2024,5,29,11,0), LocalDateTime.of(2024,5,29,11,30));
		Track tr4 = new Track(4L,"Track 4", LocalDateTime.of(2024,5,29,11,30), LocalDateTime.of(2024,5,29,12,30));
		Track tr5 = new Track(5L,"Track 5", LocalDateTime.of(2024,5,29,12,30), LocalDateTime.of(2024,5,29,13,30));
		Track tr6 = new Track(6L,"Track 6", LocalDateTime.of(2024,5,29,13,30), LocalDateTime.of(2024,5,29,15,30));
		Track tr7 = new Track(7L,"Track 7", LocalDateTime.of(2024,5,29,15,30), LocalDateTime.of(2024,5,29,16,30));
		Track tr8 = new Track(8L,"Track 8", LocalDateTime.of(2024,5,29,16,30), LocalDateTime.of(2024,5,29,17,30));
		Track tr9 = new Track(9L,"Track 9", LocalDateTime.of(2024,5,29,17,30), LocalDateTime.of(2024,5,29,18,0));
		Track tr10 = new Track(10L, "Track 10", LocalDateTime.of(2024,5,30,9,0), LocalDateTime.of(2024,5,30,10,0));
		Track tr11 = new Track(11L, "Track 11", LocalDateTime.of(2024,5,30,10,0), LocalDateTime.of(2024,5,30,11,0));
		Track tr12 = new Track(12L, "Track 12", LocalDateTime.of(2024,5,30,11,0), LocalDateTime.of(2024,5,30,11,30));
		Track tr13 = new Track(13L, "Track 13", LocalDateTime.of(2024,5,30,11,30), LocalDateTime.of(2024,5,30,12,30));
		Track tr14 = new Track(14L, "Track 14", LocalDateTime.of(2024,5,30,12,30), LocalDateTime.of(2024,5,30,13,30));
		Track tr15 = new Track(15L, "Track 15", LocalDateTime.of(2024,5,30,13,30), LocalDateTime.of(2024,5,30,15,30));
		Track tr16 = new Track(16L, "Track 16", LocalDateTime.of(2024,5,30,15,30), LocalDateTime.of(2024,5,30,16,30));
		Track tr17 = new Track(17L, "Track 17", LocalDateTime.of(2024,5,30,16,30), LocalDateTime.of(2024,5,30,17,30));
		Track tr18 = new Track(18L, "Track 18", LocalDateTime.of(2024,5,30,17,30), LocalDateTime.of(2024,5,30,18,0));
		trackRepository.saveAll(List.of(tr1, tr2, tr3, tr4, tr5, tr6, tr7, tr8, tr9, tr10, tr11, tr12, tr13,tr14,tr15,tr16,tr17,tr18));

		Ticket ticket1 = new Ticket(null, "Ticket1", 50.0, 10);
		Ticket ticket2 = new Ticket(null, "Ticket2", 50.0, 10);
		Ticket ticket3 = new Ticket(null, "Ticket3", 50.0, 10);
		ticketRepo.saveAll(List.of(ticket1, ticket2, ticket3));

		TicketOrderBuy ticketOrderBuy1 = new TicketOrderBuy(null, LocalDateTime.now(), 20.0, 50.0,10,"Tarjeta credito","ONLINE","CodigoqrUrl");
		TicketOrderBuy ticketOrderBuy2 = new TicketOrderBuy(null, LocalDateTime.now(), 20.0, 50.0,10,"Tarjeta debito ","OFFLINE","CodigoqrUrl");
		TicketOrderBuy ticketOrderBuy3 = new TicketOrderBuy(null, LocalDateTime.now(), 20.0, 50.0,10,"Tarjeta credito","ONLINE","CodigoqrUrl");
		ticketOrderBuyRepository.saveAll(List.of(ticketOrderBuy1, ticketOrderBuy2, ticketOrderBuy3));

	//	Keynote keynote1 = new Keynote(1L, "Inteligencia Artificial", "Desarrollo e implicaciones de la IA en nuestra sociedad", "Desripcion detallada de la IA", "www.youtube.com", 22, 300,"bajo", 60);


	}
}
