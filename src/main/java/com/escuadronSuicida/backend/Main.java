package com.escuadronSuicida.backend;

import com.escuadronSuicida.backend.models.*;
import com.escuadronSuicida.backend.repository.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate;
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

		ticketOrderBuyRepository.deleteAll();
		ticketRepo.deleteAll();
		commentRepository.deleteAll();
		keynoteRepository.deleteAll();
		trackRepository.deleteAll();
		roomRepository.deleteAll();
		userRepository.deleteAll();

		PasswordEncoder passwordEncoder = context.getBean(PasswordEncoder.class);
		User u1 = User.builder()
				.firstName("Pablo")
				.lastName("González")
				.userName("pablouser1")
				.email("pablo@gmail.com")
				.password(passwordEncoder.encode("pablo1234"))
				.phone("657478901")
				.address("callePablo, 2, 28046, Madrid, Madrid")
				.photoUrl(null)
				.userRole(UserRole.USER)
				.build();

		User u2 = User.builder()
				.firstName("Oscar")
				.lastName("Catalán")
				.userName("oscaru2")
				.email("oscar@gmail.com")
				.password(passwordEncoder.encode("oscar1234"))
				.phone("663501200")
				.address("calleOscar, 46, 28011, Madrid, Madrid")
				.photoUrl(null)
				.userRole(UserRole.USER)
				.build();

		User u3 = User.builder()
				.firstName("Trevor")
				.lastName("Irish")
				.userName("trevoru3")
				.email("trevor@gmail.com")
				.password(passwordEncoder.encode("trevor1234"))
				.phone("+1 415-555-1234")
				.address("1234 TrevorSt, San Francisco, CA 94123, USA")
				.photoUrl(null)
				.userRole(UserRole.USER)
				.build();

		User u4 = User.builder()
				.firstName("Eutimio")
				.lastName("Developer")
				.userName("eutimiou4")
				.email("eutimio@gmail.com")
				.password(passwordEncoder.encode("eutimio1234"))
				.phone("619567144")
				.address("calleEutimio, 23, 28004, Madrid, Madrid")
				.photoUrl(null)
				.userRole(UserRole.ADMIN)
				.build();

		User u5 = User.builder()
				.firstName("Leocadia")
				.lastName("Sigüenza")
				.userName("leocadiau5")
				.email("leocadia@gmail.com")
				.password(passwordEncoder.encode("leocadia1234"))
				.phone("661541094")
				.address("calleLeocadia, 10, 02001, Albacete, Albacete")
				.photoUrl(null)
				.userRole(UserRole.USER)
				.build();

		User u6 = User.builder()
				.firstName("Javier")
				.lastName("Developer")
				.userName("JavierBRO")
				.email("jabaroosss@gmail.com")
				.password(passwordEncoder.encode("javi1234"))
				.phone("661541099")
				.address("calle Cercana a Ppio, 33, 28008, Madrid, Madrid")
				.photoUrl(null)
				.userRole(UserRole.ADMIN)
				.build();

		User u7 = User.builder()
				.firstName("Angel")
				.lastName("Martinez")
				.userName("angelo")
				.email("angel@gmail.com")
				.password(passwordEncoder.encode("admin1234"))
				.phone("666777888")
				.address("Avda. del Escuadrón Suicida")
				.photoUrl(null)
				.userRole(UserRole.ADMIN)
				.build();
		userRepository.saveAll(List.of(u1, u2, u3, u4, u5, u6, u7));

		Room room1 = new Room(null, "Innovation Tech Hall", 500, false, "room.01.jpg", null);
		Room room2 = new Room(null, "ByteSphere Convergence Hall", 350, false, "room.02.jpg",null );
		Room room3 = new Room(null, "Quantum Nexus Summit Arena", 200, true, "room.03.jpg", null);
		Room room4 = new Room(null, "NanoVerse Discovery Pavilion", 400, false, "room.04.jpg", null);
		Room room5 = new Room(null, "TechHorizon Visionarium", 350,false, "room.05.jpg", null);
		roomRepository.saveAll(List.of(room1, room2, room3, room4, room5));

		Track tr1 = new Track(1L,"Día 1: Bienvenida al evento ",LocalDateTime.of(2024,5,28,9,0), LocalDateTime.of(2024,5,28,10,0));
        Track tr2 = new Track(2L,"Día 1: 10h", LocalDateTime.of(2024,5,28,10,0), LocalDateTime.of(2024,5,28,11,0));
		Track tr3 = new Track(3L,"Día 1: Desayuno",LocalDateTime.of(2024,5,28,11,0), LocalDateTime.of(2024,5,28,11,30));
		Track tr4 = new Track(4L,"Día 1: 11,30h", LocalDateTime.of(2024,5,28,11,30), LocalDateTime.of(2024,5,28,12,30));
		Track tr5 = new Track(5L,"Día 1: 12,30h", LocalDateTime.of(2024,5,28,12,30), LocalDateTime.of(2024,5,28,13,30));
		Track tr6 = new Track(6L,"Día 1: Almuerzo", LocalDateTime.of(2024,5,28,13,30), LocalDateTime.of(2024,5,28,15,30));
		Track tr7 = new Track(7L,"Día 1: 15,30h", LocalDateTime.of(2024,5,28,15,30), LocalDateTime.of(2024,5,28,16,30));
		Track tr8 = new Track(8L,"Día 1: 16,30h", LocalDateTime.of(2024,5,28,16,30), LocalDateTime.of(2024,5,28,17,30));
		Track tr9 = new Track(9L,"Día 1: Cierre hasta mañana", LocalDateTime.of(2024,5,28,17,30), LocalDateTime.of(2024,5,28,18,0));
		Track tr10 = new Track(10L, "Día 2: 9h", LocalDateTime.of(2024,5,29,9,0), LocalDateTime.of(2024,5,29,10,0));
		Track tr11 = new Track(11L, "Día 2: 10h", LocalDateTime.of(2024,5,29,10,0), LocalDateTime.of(2024,5,29,11,0));
		Track tr12 = new Track(12L, "Día 2: Desayuno", LocalDateTime.of(2024,5,29,11,0), LocalDateTime.of(2024,5,29,11,30));
		Track tr13 = new Track(13L, "Día 2: 11,30h", LocalDateTime.of(2024,5,29,11,30), LocalDateTime.of(2024,5,29,12,30));
		Track tr14 = new Track(14L, "Día 2: 12,30h", LocalDateTime.of(2024,5,29,12,30), LocalDateTime.of(2024,5,29,13,30));
		Track tr15 = new Track(15L, "Día 2: Almuerzo", LocalDateTime.of(2024,5,29,13,30), LocalDateTime.of(2024,5,29,15,30));
		Track tr16 = new Track(16L, "Día 2: 15,30h", LocalDateTime.of(2024,5,29,15,30), LocalDateTime.of(2024,5,29,16,30));
		Track tr17 = new Track(17L, "Día 2: 16,30h", LocalDateTime.of(2024,5,29,16,30), LocalDateTime.of(2024,5,29,17,30));
		Track tr18 = new Track(18L, "Día 2: Cierre evento", LocalDateTime.of(2024,5,29,17,30), LocalDateTime.of(2024,5,29,18,0));

		trackRepository.saveAll(List.of(tr1, tr2, tr3, tr4, tr5, tr6, tr7, tr8, tr9, tr10, tr11, tr12, tr13,tr14,tr15,tr16,tr17,tr18));

		Ticket ticket1 = new Ticket(null, "Ticket1", 50.0, 10);
		Ticket ticket2 = new Ticket(null, "Ticket2", 50.0, 10);
		Ticket ticket3 = new Ticket(null, "Ticket3", 50.0, 10);

		ticketRepo.saveAll(List.of(ticket1, ticket2, ticket3));

		TicketOrderBuy ticketOrderBuy1 = new TicketOrderBuy(null,LocalDate.of(2024,5,28), LocalDate.of(2024,5,29), 20.0, 50.0,10,"Tarjeta crédito","ONLINE","Código 4itech1", null, null);
		TicketOrderBuy ticketOrderBuy2 = new TicketOrderBuy(null, LocalDate.of(2024,5,28), LocalDate.of(2024,5,29), 20.0, 50.0,10,"Tarjeta débito ","OFFLINE","Código 4itech2", null, null);
		TicketOrderBuy ticketOrderBuy3 = new TicketOrderBuy(null, LocalDate.of(2024,5,28), LocalDate.of(2024,5,29), 20.0, 50.0,10,"Tarjeta crédito","ONLINE","Código 4itech3", null, null);

		ticketOrderBuyRepository.saveAll(List.of(ticketOrderBuy1, ticketOrderBuy2, ticketOrderBuy3));

		Keynote keynote1 = new Keynote(1L, "Inteligencia Artificial",
				"Desarrollo e implicaciones de la IA en nuestra sociedad",
				"""
						La Inteligencia Artificial (IA) es un campo de la informática que busca crear máquinas capaces de realizar tareas que típicamente requieren inteligencia humana. Esto incluye el aprendizaje, el razonamiento, la resolución de problemas y la toma de decisiones.
						      
						¿Cómo funciona la IA?
						      
						La IA funciona utilizando una variedad de técnicas, incluyendo:
						      
						Aprendizaje automático: La IA aprende a partir de datos, identificando patrones y relaciones sin necesidad de ser programada explícitamente.
						Procesamiento del lenguaje natural: La IA procesa y comprende el lenguaje humano, permitiendo la comunicación entre humanos y máquinas.
						Visión artificial: La IA interpreta y analiza imágenes y videos del mundo real.
						Robótica: La IA controla y opera robots físicos, permitiendo la automatización de tareas.
						¿Cuáles son las aplicaciones de la IA?
						      
						La IA tiene una amplia gama de aplicaciones en diversos sectores, como:
						      
						Salud: La IA se utiliza para desarrollar nuevos medicamentos, diagnosticar enfermedades y brindar atención médica personalizada.
						Finanzas: La IA se utiliza para detectar fraudes, gestionar inversiones y asesorar a clientes financieros.
						Transporte: La IA se utiliza para desarrollar vehículos autónomos, optimizar el tráfico y mejorar la seguridad vial.
						Manufactura: La IA se utiliza para automatizar tareas de producción, optimizar la cadena de suministro y mejorar la calidad del producto.
						Agricultura: La IA se utiliza para optimizar el riego, la fertilización y la cosecha, y para predecir el rendimiento de los cultivos.
						¿Cuál es el impacto de la IA?
						      
						La IA tiene el potencial de generar un impacto significativo en la sociedad, tanto positivo como negativo. Es importante considerar cuidadosamente los beneficios y riesgos de la IA a medida que continuamos desarrollándola e implementándola.
						      
						Beneficios potenciales de la IA:
						      
						Mayor eficiencia y productividad
						Mejor toma de decisiones
						Nuevos productos y servicios
						Soluciones a problemas complejos
						Riesgos potenciales de la IA:
						      
						Desempleo
						Discriminación
						Pérdida de privacidad
						Armas autónomas
						¿Qué depara el futuro de la IA?
						      
						La IA es un campo en rápido desarrollo con un enorme potencial para transformar nuestras vidas. A medida que la tecnología continúa avanzando, es probable que veamos aún más aplicaciones innovadoras de la IA en los próximos años.
						      
						Es importante recordar que la IA es una herramienta y, como cualquier herramienta, puede usarse para el bien o para el mal. Depende de nosotros asegurarnos de que la IA se use de manera responsable y ética para el beneficio de toda la humanidad.
						""","AI_2.png",
				"https://www.youtube.com/watch?v=MgWtYXcUg9Y",
				room1, 300L,DifficultyLevel.JUNIOR,45,u4,tr1,null);
		Keynote keynote2 = new Keynote(2L, "Realidad Virtual",
				"Realidad Virtual (VR) y Realidad Aumentada (AR), casos de uso",
				"La Realidad Virtual (VR) nos transporta a mundos virtuales vívidos y simulados, donde podemos interactuar con objetos y entornos como si estuviéramos realmente allí. Con gafas VR y sensores, podemos explorar paisajes fantásticos, participar en juegos en 3D o incluso asistir a conciertos virtuales. La VR tiene un gran potencial en el entrenamiento, donde permite simulaciones realistas para pilotos o cirujanos, o en la terapia, donde ayuda a pacientes con fobias o trastornos de estrés postraumático. Sin embargo, la VR también puede generar mareos u otros efectos secundarios en algunos usuarios, y es importante considerar estos aspectos al utilizarla.","realidad_virtual.png", null,
				room2, 200L,DifficultyLevel.SENIOR,60,u1,tr2,null);
		Keynote keynote3 = new Keynote(3L, "Experiencia de Usuario (UX)",
				"Desarrollo e implicaciones de una mejora de experiencia de usuario",
				"La Experiencia de Usuario (UX) se centra en crear interfaces y experiencias de usuario intuitivas, atractivas y fáciles de usar. Es un campo fundamental en el desarrollo de productos digitales y servicios, ya que busca comprender las necesidades, expectativas y comportamientos de los usuarios para crear soluciones que sean útiles, agradables y satisfagan sus expectativas. La UX implica un proceso de investigación, diseño, iteración y evaluación que involucra a diversos profesionales, como diseñadores UX, investigadores de usabilidad, y desarrolladores.\n" +
						"\n" +
						"Un buen diseño UX tiene un impacto positivo en la satisfacción del usuario, la lealtad a la marca y el éxito del producto. Un producto con una UX deficiente puede generar frustración, confusión y abandono por parte de los usuarios, mientras que un buen diseño UX puede aumentar la productividad, el disfrute y la adopción del producto. La UX se aplica en una amplia gama de áreas, desde aplicaciones móviles y sitios web hasta software empresarial y sistemas de información. En un mundo cada vez más digital, la UX es esencial para crear productos y servicios que sean relevantes, usables y que brinden una experiencia positiva a los usuarios.","UX.png",
				null,
				room4, 300L,DifficultyLevel.SEMI_SENIOR,45,u5,tr2,null);
		Keynote keynote4 = new Keynote(4L, "Ciberseguridad",
				"Ciberseguridad, protegiendo el mundo digital contra accesos no autorizados, ataques y fraudes",
				"En la era digital, la Ciberseguridad es fundamental para proteger nuestros sistemas informáticos, datos y privacidad. Con el aumento de ataques cibernéticos sofisticados, es crucial contar con medidas de seguridad adecuadas para prevenir el acceso no autorizado, el robo de datos o el fraude. La Ciberseguridad abarca una amplia gama de prácticas, desde el uso de contraseñas seguras y la instalación de antivirus hasta la realización de copias de seguridad y la formación del personal en materia de seguridad. Las empresas y organizaciones deben invertir en Ciberseguridad para proteger su información vital y la de sus clientes.","cibersecurity_2.png", null,
				room3, 150L,DifficultyLevel.SENIOR,50,u3,tr3,null);
		Keynote keynote5 = new Keynote(5L, "Cloud Computing",
				"Cloud Computing: desarrollo y avances en la computación en la nube",
				"El Cloud Computing ha transformado la forma en que almacenamos, accedemos y procesamos la información. En lugar de depender de servidores físicos en nuestras instalaciones, podemos acceder a recursos informáticos (servidores, almacenamiento, bases de datos) a través de Internet. Esto ofrece múltiples ventajas: escalabilidad (podemos aumentar o disminuir los recursos según nuestras necesidades), flexibilidad (podemos acceder a nuestros datos desde cualquier lugar), y colaboración (podemos trabajar en proyectos en equipo de forma remota). El Cloud Computing es utilizado por empresas de todos los tamaños, desde startups hasta grandes corporaciones, y ha impulsado la innovación en diversos sectores.","cloud_computing3.png", null,
				room3, 150L,DifficultyLevel.SENIOR,50,u7,tr4,null);

		Keynote keynote6 = new Keynote(6L, "Blockchain",
				"Blockchain: Transparencia y seguridad en las transacciones",
				"La tecnología Blockchain ha introducido un nuevo paradigma en la forma en que realizamos transacciones. Se trata de un registro distribuido que almacena información de forma segura, transparente e inmutable. Cada transacción se registra en bloques que se vinculan entre sí, creando una cadena de bloques. Esto permite la trazabilidad y verificación de las transacciones, sin necesidad de intermediarios. Blockchain es la base de las criptomonedas como Bitcoin, pero también tiene aplicaciones en diversos sectores, como la gestión de la cadena de suministro, los registros médicos electrónicos o el voto electrónico. Su potencial para mejorar la transparencia, la eficiencia y la seguridad en las transacciones es enorme.","blockchain.png", null,
				room3, 150L,DifficultyLevel.SENIOR,50,u2,tr5,null);
		Keynote keynote7 = new Keynote(7L, "Big Data",
				"Big Data: Descifrando el poder de los datos",
				"El Big Data se refiere al análisis de grandes conjuntos de datos para extraer información valiosa. Con el auge de sensores, dispositivos conectados y redes sociales, la cantidad de datos generados diariamente es colosal. El Big Data permite a las empresas analizar patrones, tendencias y comportamientos de sus clientes, tomar decisiones más informadas, optimizar sus operaciones y desarrollar nuevos productos y servicios. El análisis de Big Data también se utiliza en áreas como la investigación científica, la medicina personalizada y la gestión de riesgos financieros. Sin embargo, la gestión y el análisis de Big Data presentan desafíos técnicos y éticos, como la privacidad de los datos y la protección de la información personal.","big_data_2.png", null,
				room3, 150L,DifficultyLevel.SENIOR,50,u3,tr6,null);
		Keynote keynote8 = new Keynote(8L, "Internet de las cosas (IoT)",
				"IoT: Un mundo conectado",
				"El Internet de las Cosas (IoT) conecta objetos físicos a Internet, permitiendo su monitoreo y control remoto. Desde electrodomésticos inteligentes que se controlan con la voz hasta sensores que recopilan datos sobre el medio ambiente, el IoT está transformando nuestro entorno. La información recopilada por los dispositivos IoT puede utilizarse para mejorar la eficiencia energética, optimizar la gestión de recursos, o incluso salvar vidas en el ámbito de la salud. Sin embargo, la seguridad y la privacidad","IoT.png", null,
				room3, 150L,DifficultyLevel.SENIOR,50,u5,tr5,null);
//        Keynote keynote5 = Keynote.builder()
//                .title("Ciberseguridad")
//                .summary("Ciberseguridad, protegiendo el mundo digital contra accesos no autorizados, ataques y fraudes")
//                .description("En la era digital, la Ciberseguridad es fundamental para proteger nuestros sistemas informáticos, datos y privacidad. Con el aumento de ataques cibernéticos sofisticados, es crucial contar con medidas de seguridad adecuadas para prevenir el acceso no autorizado, el robo de datos o el fraude. La Ciberseguridad abarca una amplia gama de prácticas, desde el uso de contraseñas seguras y la instalación de antivirus hasta la realización de copias de seguridad y la formación del personal en materia de seguridad. Las empresas y organizaciones deben invertir en Ciberseguridad para proteger su información vital y la de sus clientes.")
//				.photoUrl("cibersecurity_2.png")
//                .webinarUrl(null)
//                .room(room1)
//				.maxNumPersons(300L)
//                .difficultyLevel(DifficultyLevel.JUNIOR)
//				.durationInMin(90)
//                .speaker(user3)
//                .track(tr7)
//                .attendees(null)
//                .build();
		keynoteRepository.saveAll(List.of(keynote1,keynote2,keynote3,keynote4, keynote5, keynote6, keynote7, keynote8));

		Comment c1 = new Comment(1L,
				3,
				"Fascinante, revelando el increíble potencial creativo " +
						"de las máquinas en la producción de contenido único y original.",
				LocalDateTime.of(2024, 4,2, 10,15),u1, keynote4);
		Comment c2 = new Comment(2L,
				4,
				"Me dejó asombrado, destacando cómo la tecnología puede generar " +
						"ideas innovadoras y abrir nuevas posibilidades en el ámbito " +
						"creativo.",
				LocalDateTime.of(2024, 4,6, 12,35),u2, keynote1);
		Comment c3 = new Comment(3L,
				5,
				"Fue esclarecedora, mostrando cómo estas avanzadas tecnologías " +
						"están transformando la forma en que concebimos y creamos contenido " +
						"de manera revolucionaria.",
				LocalDateTime.now(),u5, keynote2);
		Comment c4 = new Comment(4L,
				1,
				"Fue un poco desastre la ponencia no esclarecedora de estas avanzadas tecnologías que " +
						"están transformando la manera en que concebimos y creamos contenido " +
						"de manera revolucionaria.",
				LocalDateTime.of(2024, 4,2, 21,15),u4, keynote3);

		commentRepository.saveAll(List.of(c1, c2, c3, c4));

	}
}