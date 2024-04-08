package com.escuadronSuicida.backend;

import com.escuadronSuicida.backend.models.*;
import com.escuadronSuicida.backend.repository.*;
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
		KeynoteRepository keynoteRepository = context.getBean(KeynoteRepository.class);
		CommentRepository commentRepository = context.getBean(CommentRepository.class);

		User user6 = new User(null,
				"Pablo",
				"González",
				"pablo@gmail.com",
				"657478901",
				"pablou1",
				"pablou1",
				"callePablo, 2, 28046, Madrid, Madrid",
				UserRole.USER
		);
		User user2 = new User(null,
				"Oscar",
				"Catalan",
				"oscar@yahoo.es",
				"663501200",
				"oscaru2",
				"oscaru2",
				"calleOscar, 46, 28011, Madrid, Madrid",
				UserRole.USER

		);
		User user3 = new User(null,
				"Trevor",
				"McIntosh",
				"trevor@apple.com",
				"+1 415-555-1234",
				"trevor@apple.com",
				"trevoru3",
				"1234 TrevorSt, San Francisco, CA 94123, USA",
				UserRole.USER
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
				UserRole.USER
		);
		User user1 = new User(null, "Javier", "Developer", "jabaroosss@gmail.com",
				"661541099", "JavierBRO", "admin4321",
				"calle Cercana a Ppio, 33, 28008, Madrid, Madrid",
				UserRole.ADMIN
		);
		userRepository.saveAll(List.of(user1, user2, user3, user4, user5, user6));

		Room room1 = new Room(null, "Innovation Tech Hall", 500, false, "foto.png", null);
		Room room2 = new Room(null, "ByteSphere Convergence Hall", 350, false, "https://placehold.co/600x400.png",null );
		Room room3 = new Room(null, "Quantum Nexus Summit Arena", 200, true, "https://placehold.co/600x400.png", null);
		Room room4 = new Room(null, "NanoVerse Discovery Pavilion", 400, false, "https://placehold.co/600x400.png", null);
		Room room5 = new Room(null, "TechHorizon Visionarium", 350,false, "https://placehold.co/600x400.png", null);
        Room room6 = Room.builder()
                .name("Little Room")
                .capacity(100)
                .hasSockets(true)
                .keynotes(null)
                .build();

		roomRepository.saveAll(List.of(room1, room2, room3, room4, room5, room6));

		Track tr1 = new Track(1L,"Track 1",LocalDateTime.of(2024,5,29,9,0), LocalDateTime.of(2024,5,29,10,0));
        Track tr2 = new Track(2L,"Track2", LocalDateTime.of(2024,5,29,10,0), LocalDateTime.of(2024,5,29,11,0));
		Track tr3 = new Track(3L,"Track 3",LocalDateTime.of(2024,5,29,11,0), LocalDateTime.of(2024,5,29,11,30));
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

		TicketOrderBuy ticketOrderBuy1 = new TicketOrderBuy(null, LocalDateTime.now(), 20.0, 50.0,10,"Tarjeta credito","ONLINE","CodigoqrUrl 1", null, null);
		TicketOrderBuy ticketOrderBuy2 = new TicketOrderBuy(null, LocalDateTime.now(), 20.0, 50.0,10,"Tarjeta debito ","OFFLINE","CodigoqrUrl 2", null, null);
		TicketOrderBuy ticketOrderBuy3 = new TicketOrderBuy(null, LocalDateTime.now(), 20.0, 50.0,10,"Tarjeta credito","ONLINE","CodigoqrUrl 3", null, null);

		ticketOrderBuyRepository.saveAll(List.of(ticketOrderBuy1, ticketOrderBuy2, ticketOrderBuy3));

		Keynote keynote1 = new Keynote(1L, "Inteligencia Artificial",
				"Desarrollo e implicaciones de la IA en nuestra sociedad",
				"La inteligencia artificial (IA) ha experimentado un desarrollo exponencial en las últimas décadas. Los avances en algoritmos, hardware y la disponibilidad de grandes cantidades de datos han impulsado su crecimiento.",
				"/assets/keynotes/AI.jpeg",
				room1, 300L,DifficultyLevel.JUNIOR,45,null,tr4,null);
		Keynote keynote2 = new Keynote(2L, "La Era Digital JAVA",
				"Desarrollo de código Java Global",
				"Java es un lenguaje de programación de propósito general, creado por Sun Microsystems en 1995. Su desarrollo se basó en la idea de crear un lenguaje orientado a objetos, robusto, seguro, portable y de alto rendimiento.", "/assets/keynotes/Java.jpeg",
				room2, 200L,DifficultyLevel.SENIOR,60,null,tr11,null);
		Keynote keynote3 = new Keynote(3L, "El Mejor Frontend con Angular ",
				"Desarrollo e implicaciones de la IA en nuestra sociedad",
				"Angular es un framework de desarrollo web de código abierto, basado en TypeScript, creado y mantenido por Google. Se utiliza para crear aplicaciones web de una sola página (SPA) dinámicas e interactivas.",
				"/assets/keynotes/Angular.jpeg",
				room4, 300L,DifficultyLevel.SEMI_SENIOR,45,null,tr17,null);
		Keynote keynote4 = new Keynote(4L, "Salud Digital",
				"Desarrollo e implicaciones de la salud por el uso de las tecnologías de abuso en nuestra sociedad",
				"El desarrollo de las tecnologías de abuso ha ido en aumento en los últimos años. Estas tecnologías incluyen el uso de internet, las redes sociales, los videojuegos y los teléfonos móviles de forma excesiva o compulsiva.", "/assets/keynotes/salud-digital.jpeg",
				room3, 150L,DifficultyLevel.SENIOR,50,user3,tr14,null);
        Keynote keynote5 = Keynote.builder()
                .title("No hay Frontend sin Backend ")
                .summary("Explicaciones didácticas y prácticas sobre el papél que juega cada uno de los desarrollos en la creación de páginas web ")
                .description("Increible, el diseño en frontend y el control en backend que nos permite crear cualquier tipo de página web de forma dinámica y resolver cualquier problema real de un servicio a ofrecer a cualquier usuario del planeta de forma sencilla y generar bases de datos de información interesante en todos los aspectos. No se puede concebir un frontend sin un backend robusto y bien desarrollado con código limpio y funcional...")
                .webinarUrl("/assets/keynotes/no-frontend-sin-backend.jpeg")
                .room(room1)
                .durationInMin(55)
                .difficultyLevel(DifficultyLevel.JUNIOR)
                .speaker(user3)
                .track(tr7)
                .maxNumPersons(150L)
                .attendees(List.of(user1,user2, user5))
                .build();


		keynoteRepository.saveAll(List.of(keynote1,keynote2,keynote3,keynote4,keynote5));


		Comment c1 = new Comment(1L,
				3,
				"Fascinante, revelando el increíble potencial creativo " +
						"de las máquinas en la producción de contenido único y original.",
				LocalDateTime.of(2024, 4,2, 10,15),user1, keynote4);
		Comment c2 = new Comment(2L,
				4,
				"me dejó asombrado, destacando cómo la tecnología puede generar " +
						"ideas innovadoras y abrir nuevas posibilidades en el ámbito " +
						"creativo.",
				LocalDateTime.of(2024, 4,6, 12,35),user2, keynote1);
		Comment c3 = new Comment(3L,
				5,
				"fue esclarecedora, mostrando cómo estas avanzadas tecnologías " +
						"están transformando la forma en que concebimos y creamos contenido " +
						"de manera revolucionaria.",
				LocalDateTime.now(),user5, keynote2);
		Comment c4 = new Comment(4L,
				1,
				"fue un poco desastre la ponencia no esclarecedora de estas avanzadas tecnologías que " +
						"están transformando la manera en que concebimos y creamos contenido " +
						"de manera revolucionaria.",
				LocalDateTime.of(2024, 4,2, 21,15),user4, keynote3);



		commentRepository.saveAll(List.of(c1, c2, c3, c4));

	}

}