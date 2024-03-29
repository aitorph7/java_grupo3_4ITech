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

		Room room1 = new Room(null, "Innovation Tech Hall", 500, false, null);
		Room room2 = new Room(null, "ByteSphere Convergence Hall", 350, false,null );
		Room room3 = new Room(null, "Quantum Nexus Summit Arena", 200, true, null);
		Room room4 = new Room(null, "NanoVerse Discovery Pavilion", 400, false, null);
		Room room5 = new Room(null, "TechHorizon Visionarium", 350,false, null);

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

		TicketOrderBuy ticketOrderBuy1 = new TicketOrderBuy(null, LocalDateTime.now(), 20.0, 50.0,10,"Tarjeta credito","ONLINE","CodigoqrUrl 1", null, null);
		TicketOrderBuy ticketOrderBuy2 = new TicketOrderBuy(null, LocalDateTime.now(), 20.0, 50.0,10,"Tarjeta debito ","OFFLINE","CodigoqrUrl 2", null, null);
		TicketOrderBuy ticketOrderBuy3 = new TicketOrderBuy(null, LocalDateTime.now(), 20.0, 50.0,10,"Tarjeta credito","ONLINE","CodigoqrUrl 3", null, null);

		ticketOrderBuyRepository.saveAll(List.of(ticketOrderBuy1, ticketOrderBuy2, ticketOrderBuy3));

		Keynote keynote1 = new Keynote(1L, "Inteligencia Artificial",
				"Desarrollo e implicaciones de la IA en nuestra sociedad",
				"La inteligencia artificial (IA) ha experimentado un desarrollo exponencial en las últimas décadas. Los avances en algoritmos, hardware y la disponibilidad de grandes cantidades de datos han impulsado su crecimiento. En este evento, exploraremos las últimas tendencias en IA y su impacto en diferentes sectores. Expertos de la industria compartirán sus conocimientos sobre las aplicaciones prácticas de la IA en áreas como la medicina, las finanzas, el transporte, la educación y mucho más.\n" +
						"\n" +
						"También tendremos la oportunidad de participar en debates y mesas redondas para discutir los desafíos y oportunidades que presenta la IA. Aprenderemos cómo podemos aprovechar el poder de la IA para crear un futuro mejor para todos.\n" +
						"\n" +
						"Este evento es ideal para:\n" +
						"\n" +
						"Profesionales que buscan conocer las últimas tendencias en IA\n" +
						"Emprendedores que buscan explorar nuevas oportunidades de negocio\n" +
						"Estudiantes que quieren aprender sobre el futuro de la tecnología\n" +
						"Cualquier persona interesada en el impacto de la IA en la sociedad\n" +
						"No pierdas la oportunidad de ser parte de esta conversación crucial sobre el futuro de la inteligencia artificial.\n" +
						"\n" +
						"¡Reserva tu lugar hoy mismo!\n" +
						"\n" +
						"Aquí hay algunos temas específicos que podrían abordarse en el evento:\n" +
						"\n" +
						"El impacto de la IA en el mercado laboral: ¿Cómo afectará la IA a los trabajos existentes? ¿Qué nuevas oportunidades se crearán?\n" +
						"Los desafíos éticos de la IA: ¿Cómo podemos asegurarnos de que la IA se use de forma responsable y ética?\n" +
						"El futuro de la IA: ¿Cuáles son las aplicaciones más prometedoras de la IA en los próximos años?\n" +
						"Además de las ponencias y mesas redondas, el evento podría incluir:\n" +
						"\n" +
						"Demostraciones de tecnología: Presentaciones de las últimas tecnologías de IA en acción.\n" +
						"Talleres prácticos: Oportunidades para aprender a usar herramientas de IA.\n" +
						"Networking: Oportunidades para conectar con otros profesionales interesados en la IA.\n" +
						"Al participar en este evento, los asistentes podrán:\n" +
						"\n" +
						"Obtener una comprensión completa del panorama actual de la IA.\n" +
						"Aprender sobre las aplicaciones prácticas de la IA en diferentes sectores.\n" +
						"Conocer a expertos en IA y establecer contactos con otros profesionales.\n" +
						"Reflexionar sobre los desafíos y oportunidades que presenta la IA para el futuro.\n" +
						"Este evento es una oportunidad única para aprender sobre la IA y su impacto en el mundo.",
				"/assets/keynotes/AI.jpeg",
				room1, 300L,DifficultyLevel.JUNIOR,45,null,tr3,null);
		Keynote keynote2 = new Keynote(2L, "La Era Digital JAVA",
				"Desarrollo de código Java Global",
				"Java es un lenguaje de programación de propósito general, creado por Sun Microsystems en 1995. Su desarrollo se basó en la idea de crear un lenguaje orientado a objetos, robusto, seguro, portable y de alto rendimiento.\n La era digital Java marca un período en el que la tecnología Java se ha convertido en una fuerza omnipresente, impulsando una amplia gama de aplicaciones y sistemas que transforman la forma en que vivimos, trabajamos y jugamos. Desde el desarrollo web a gran escala hasta la creación de aplicaciones móviles omnipresentes, Java se ha convertido en el lenguaje de programación de elección para construir soluciones digitales robustas y escalables.", "/assets/keynotes/Java.jpeg",
				room2, 200L,DifficultyLevel.SENIOR,60,null,tr10,null);
		Keynote keynote3 = new Keynote(3L, "El Mejor Front con Angular ",
				"Ventajas de Angular como framework para desarrollar interfaces de usuario (frontends) de alta calidad.",
				"Angular es un framework de desarrollo web de código abierto, basado en TypeScript, creado y mantenido por Google. Se utiliza para crear aplicaciones web de una sola página (SPA) dinámicas e interactivas. El mejor frontend con Angular no es solo una frase, es una realidad tangible para aquellos que buscan crear interfaces de usuario web que sean atractivas, interactivas, eficientes y escalables. En resumen, si buscas crear interfaces de usuario web excepcionales que sean atractivas, interactivas, eficientes, escalables y respaldadas por una comunidad vibrante, Angular es la mejor opción para tu proyecto. ",
				"/assets/keynotes/Angular.jpeg",
				room4, 300L,DifficultyLevel.SEMI_SENIOR,45,null,tr12,null);
		Keynote keynote4 = new Keynote(4L, "Salud Digital",
				"Desarrollo e implicaciones de la salud por el uso de las tecnologías de abuso en nuestra sociedad",
				"El desarrollo de las tecnologías de abuso ha ido en aumento en los últimos años. Estas tecnologías incluyen el uso de internet, las redes sociales, los videojuegos y los teléfonos móviles de forma excesiva o compulsiva. La Salud Digital es un campo en constante evolución que utiliza las tecnologías de la información y la comunicación (TIC) para mejorar la salud y el bienestar de las personas. Su objetivo es transformar la atención médica tradicional, haciéndola más accesible, eficiente, personalizada y preventiva.", "/assets/keynotes/salud-digital.jpeg",
				room3, 150L,DifficultyLevel.SENIOR,50,user3,tr18,null);

		keynoteRepository.saveAll(List.of(keynote1,keynote2,keynote3,keynote4));


		Comment c1 = new Comment(1L,
				3,
				"Fascinante, revelando el increíble potencial creativo " +
						"de las máquinas en la producción de contenido único y original.",
				user1, keynote4);
		Comment c2 = new Comment(2L,
				4,
				"me dejó asombrado, destacando cómo la tecnología puede generar " +
						"ideas innovadoras y abrir nuevas posibilidades en el ámbito " +
						"creativo.",
				user2, keynote1);
		Comment c3 = new Comment(3L,
				5,
				"fue esclarecedora, mostrando cómo estas avanzadas tecnologías " +
						"están transformando la forma en que concebimos y creamos contenido " +
						"de manera revolucionaria.",
				user5, keynote2);
		Comment c4 = new Comment(4L,
				1,
				"fue un poco desastre la ponencia no esclarecedora de estas avanzadas tecnologías que " +
						"están transformando la manera en que concebimos y creamos contenido " +
						"de manera revolucionaria.",
				user4, keynote3);



		commentRepository.saveAll(List.of(c1, c2, c3, c4));

	}

}