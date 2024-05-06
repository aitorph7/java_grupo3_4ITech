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
				.photoUrl("speaker6.jpeg")
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
				.photoUrl("speaker13.webp")
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
				.photoUrl("speaker10.webp")
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
				.photoUrl("speaker4.jpeg")
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
				.photoUrl("speaker3.jpeg")
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
				.photoUrl("speaker20.png")
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
				.photoUrl("speaker19.jpeg")
				.userRole(UserRole.ADMIN)
				.build();
		User u8 = User.builder()
				.firstName("Alan")
				.lastName("Sastre")
				.userName("Alan")
				.email("alan@gmail.com")
				.password(passwordEncoder.encode("admin1234"))
				.phone("666777888")
				.address("Avda. Corazón de María 38")
				.photoUrl("speaker21.png")
				.userRole(UserRole.ADMIN)
				.build();
		userRepository.saveAll(List.of(u1, u2, u3, u4, u5, u6, u7, u8));

		Room room1 = new Room(null, "Innovation Tech Hall", 500, true, "room.01.jpg", null);
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


		Ticket ticket1 = new Ticket(null, "Plata", 50.0, 10);
		Ticket ticket2 = new Ticket(null, "Oro", 50.0, 10);
		Ticket ticket3 = new Ticket(null, "Diamante", 50.0, 10);

		ticketRepo.saveAll(List.of(ticket1, ticket2, ticket3));

		TicketOrderBuy ticketOrderBuy1 = new TicketOrderBuy(null,LocalDate.of(2024,5,28), LocalDate.of(2024,5,29), 10.0, 50.0,2,"Tarjeta crédito","ONLINE","Código 4itech1", null, null);
		TicketOrderBuy ticketOrderBuy2 = new TicketOrderBuy(null, LocalDate.of(2024,5,28), LocalDate.of(2024,5,29), 10.0, 50.0,1,"Tarjeta débito ","OFFLINE","Código 4itech2", null, null);
		TicketOrderBuy ticketOrderBuy3 = new TicketOrderBuy(null, LocalDate.of(2024,5,28), LocalDate.of(2024,5,29), 10.0, 50.0,3,"Tarjeta crédito","ONLINE","Código 4itech3", null, null);

		ticketOrderBuyRepository.saveAll(List.of(ticketOrderBuy1, ticketOrderBuy2, ticketOrderBuy3));

		Keynote keynote1 = new Keynote(1L, "Inteligencia Artificial",
				"Desarrollo e implicaciones de la IA en nuestra sociedad",
				"""
						<p><strong>&iquest;Qu&eacute; es la Inteligencia Artificial (IA)?</strong></p>
						<p>La Inteligencia Artificial (IA) es un campo de la inform&aacute;tica que busca crear m&aacute;quinas capaces de realizar tareas que t&iacute;picamente requieren inteligencia humana. Esto incluye el aprendizaje, el razonamiento, la resoluci&oacute;n de problemas y la toma de decisiones.</p>
						<p><strong>&iquest;C&oacute;mo funciona la IA?</strong></p>
						<p>La IA funciona utilizando una variedad de t&eacute;cnicas, incluyendo:</p>
						<ul>
						<li><strong>Aprendizaje autom&aacute;tico:</strong> La IA aprende a partir de datos, identificando patrones y relaciones sin necesidad de ser programada expl&iacute;citamente.</li>
						<li><strong>Procesamiento del lenguaje natural:</strong> La IA procesa y comprende el lenguaje humano, permitiendo la comunicaci&oacute;n entre humanos y m&aacute;quinas.</li>
						<li><strong>Visi&oacute;n artificial:</strong> La IA interpreta y analiza im&aacute;genes y videos del mundo real.</li>
						<li><strong>Rob&oacute;tica:</strong> La IA controla y opera robots f&iacute;sicos, permitiendo la automatizaci&oacute;n de tareas.</li>
						</ul>
						<p><strong>&iquest;Cu&aacute;les son las aplicaciones de la IA?</strong></p>
						<p>La IA tiene una amplia gama de aplicaciones en diversos sectores, como:</p>
						<ul>
						<li><strong>Salud:</strong> La IA se utiliza para desarrollar nuevos medicamentos, diagnosticar enfermedades y brindar atenci&oacute;n m&eacute;dica personalizada.</li>
						<li><strong>Finanzas:</strong> La IA se utiliza para detectar fraudes, gestionar inversiones y asesorar a clientes financieros.</li>
						<li><strong>Transporte:</strong> La IA se utiliza para desarrollar veh&iacute;culos aut&oacute;nomos, optimizar el tr&aacute;fico y mejorar la seguridad vial.</li>
						<li><strong>Manufactura:</strong> La IA se utiliza para automatizar tareas de producci&oacute;n, optimizar la cadena de suministro y mejorar la calidad del producto.</li>
						<li><strong>Agricultura:</strong> La IA se utiliza para optimizar el riego, la fertilizaci&oacute;n y la cosecha, y para predecir el rendimiento de los cultivos.</li>
						</ul>
						<p><strong>&iquest;Cu&aacute;l es el impacto de la IA?</strong></p>
						<p>La IA tiene el potencial de generar un impacto significativo en la sociedad, tanto positivo como negativo. Es importante considerar cuidadosamente los beneficios y riesgos de la IA a medida que continuamos desarroll&aacute;ndola e implement&aacute;ndola.</p>
						<p><strong>Beneficios potenciales de la IA:</strong></p>
						<ul>
						<li>Mayor eficiencia y productividad</li>
						<li>Mejor toma de decisiones</li>
						<li>Nuevos productos y servicios</li>
						<li>Soluciones a problemas complejos</li>
						</ul>
						<p><strong>Riesgos potenciales de la IA:</strong></p>
						<ul>
						<li>Desempleo</li>
						<li>Discriminaci&oacute;n</li>
						<li>P&eacute;rdida de privacidad</li>
						<li>Armas aut&oacute;nomas</li>
						</ul>
						<p><strong>&iquest;Qu&eacute; depara el futuro de la IA?</strong></p>
						<p>La IA es un campo en r&aacute;pido desarrollo con un enorme potencial para transformar nuestras vidas. A medida que la tecnolog&iacute;a contin&uacute;a avanzando, es probable que veamos a&uacute;n m&aacute;s aplicaciones innovadoras de la IA en los pr&oacute;ximos a&ntilde;os.</p>
						<p><strong>Es importante recordar que la IA es una herramienta y, como cualquier herramienta, puede usarse para el bien o para el mal. Depende de nosotros asegurarnos de que la IA se use de manera responsable y &eacute;tica para el beneficio de toda la humanidad.</strong></p>
						""","AI_2.png",
				"MgWtYXcUg9Y",
				room1, 300L,DifficultyLevel.JUNIOR,45,u4,tr1,null, true);
		Keynote keynote2 = new Keynote(2L, "Realidad Virtual",
				"Realidad Virtual (VR) y Realidad Aumentada (AR), casos de uso",
				"""
						<p>La Realidad Virtual (RV) es una tecnología que crea entornos simulados en los que los usuarios pueden sumergirse y experimentar como si estuvieran realmente presentes en ellos. A través de dispositivos como cascos, guantes hápticos y sensores de movimiento, la RV permite a las personas interactuar con estos entornos virtuales de manera inmersiva y casi realista.</p>
						<p>¿Cómo funciona la RV?</p>
						<p>La RV funciona utilizando una combinación de hardware y software para crear la ilusión de estar en otro lugar. Los elementos principales de la RV incluyen:</p>
						<ul>
						<li><strong>Dispositivos de visualización:</strong> Cascos VR, gafas VR o pantallas 3D que proyectan imágenes y videos en 3D en los ojos del usuario.</li>
						<li><strong>Sensores de seguimiento:</strong> Rastrean los movimientos de la cabeza y el cuerpo del usuario, permitiendo que sus acciones se reflejen en el entorno virtual.</li>
						<li><strong>Software de RV:</strong> Crea los gráficos, sonidos y la física del entorno virtual, y controla la interacción del usuario con el mismo.</li>
						</ul>
						<p>¿Cuáles son las aplicaciones de la RV?</p>
						<p>La RV tiene una amplia gama de aplicaciones en diversos campos, como:</p>
						<ul>
						<li><strong>Entretenimiento:</strong> Juegos de RV, experiencias cinematográficas inmersivas, tours virtuales de lugares y atracciones.</li>
						<li><strong>Formación y educación:</strong> Simulaciones de entrenamiento para profesionales como pilotos, cirujanos y personal militar; experiencias educativas interactivas para estudiantes de todas las edades.</li>
						<li><strong>Terapia:</strong> Tratamiento de fobias, trastornos de ansiedad y dolor crónico; rehabilitación física y psicológica.</li>
						<li><strong>Empresas y negocios:</strong> Diseño de productos y prototipos virtuales, colaboración remota en proyectos, entrenamiento de empleados.</li>
						</ul>
						<p>¿Cuál es el impacto de la RV?</p>
						<p>La RV tiene el potencial de transformar la forma en que vivimos, trabajamos y aprendemos. A medida que la tecnología continúa desarrollándose, es probable que veamos aún más aplicaciones innovadoras de la RV en los próximos años.</p>
						<p><strong>Beneficios potenciales de la RV:</strong></p>
						<ul>
						<li>Experiencias inmersivas y realistas</li>
						<li>Mayor interacción y participación</li>
						<li>Nuevas oportunidades de aprendizaje y formación</li>
						<li>Mejoras en la productividad y la eficiencia</li>
						<li>Terapias y tratamientos más efectivos</li>
						</ul>
						<p><strong>Riesgos potenciales de la RV:</strong></p>
						<ul>
						<li>Mareos y náuseas</li>
						<li>Aislamiento social y adicción</li>
						<li>Problemas de privacidad y seguridad</li>
						<li>Impactos en la salud mental</li>
						</ul>
						<p><strong>¿Qué depara el futuro de la RV?</strong></p>
						<p>La RV es un campo en rápido desarrollo con un enorme potencial para cambiar el mundo que nos rodea. A medida que la tecnología se vuelve más accesible y asequible, es probable que la RV se integre cada vez más en nuestras vidas cotidianas.</p>
						<p>Es importante recordar que la RV es una herramienta poderosa que puede usarse para el bien o para el mal. Depende de nosotros asegurarnos de que la RV se use de manera responsable y ética para el beneficio de toda la humanidad.</p>
						""","realidad_virtual.png", "IzAuGa7YKeU",
				room2, 200L,DifficultyLevel.SENIOR,60,u1,tr2,null, true);
		Keynote keynote3 = new Keynote(3L, "Experiencia de Usuario (UX)",
				"Desarrollo e implicaciones de una mejora de experiencia de usuario",
				"""
						<p>La Experiencia de Usuario (UX) se refiere al conjunto de factores y emociones que un usuario experimenta al interactuar con un producto o servicio, especialmente en el ámbito digital. Abarca aspectos como la facilidad de uso, la utilidad, la accesibilidad, la estética y la satisfacción general del usuario.</p>
						<p><strong>¿Por qué es importante la UX?</strong></p>
						<ul>
						<li><strong>Mejorar la usabilidad:</strong> Los usuarios pueden encontrar y usar el producto o servicio de manera fácil y eficiente, sin frustraciones.</li>
						<li><strong>Aumentar la satisfacción:</strong> Los usuarios disfrutan de la experiencia y se sienten satisfechos con lo que ofrece el producto o servicio.</li>
						<li><strong>Fidelizar a los usuarios:</strong> Los usuarios que tienen una buena experiencia son más propensos a volver a usar el producto o servicio y a recomendarlo a otros.</li>
						<li><strong>Mejorar la imagen de marca:</strong> Una buena UX puede contribuir a una imagen de marca positiva y profesional.</li>
						</ul>
						<p><strong>¿Cuáles son los principios de la UX?</strong></p>
						<ul>
						<li><strong>Centrado en el usuario:</strong> El diseño debe basarse en las necesidades, expectativas y comportamientos del usuario.</li>
						<li><strong>Usabilidad:</strong> El producto o servicio debe ser fácil de usar, aprender y navegar.</li>
						<li><strong>Utilidad:</strong> El producto o servicio debe ofrecer valor real al usuario y resolver sus necesidades.</li>
						<li><strong>Accesibilidad:</strong> El producto o servicio debe ser accesible para todos los usuarios, independientemente de sus capacidades físicas o cognitivas.</li>
						<li><strong>Estética:</strong> El producto o servicio debe ser visualmente atractivo y agradable a la vista.</li>
						<li><strong>Emoción:</strong> La experiencia debe despertar emociones positivas en el usuario.</li>
						</ul>
						<p><strong>¿Cómo se diseña una buena UX?</strong></p>
						<ul>
						<li><strong>Investigación:</strong> Se realiza un estudio para comprender las necesidades, expectativas y comportamientos del usuario objetivo.</li>
						<li><strong>Definición de objetivos:</strong> Se definen los objetivos que se quieren lograr con la experiencia UX.</li>
						<li><strong>Creación de prototipos:</strong> Se crean prototipos para visualizar y probar diferentes ideas de diseño.</li>
						<li><strong>Evaluación:</strong> Se realizan pruebas de usabilidad para evaluar la efectividad del diseño y realizar mejoras.</li>
						<li><strong>Iteración:</strong> El proceso de diseño es iterativo, con constantes mejoras y ajustes en base a las pruebas y comentarios de los usuarios.</li>
						</ul>
						<p><strong>¿Cuáles son las herramientas para el diseño UX?</strong></p>
						<p>Existen diversas herramientas para el diseño UX, que incluyen:</p>
						<ul>
						<li><strong>Herramientas de wireframing:</strong> Permiten crear esquemas básicos de la interfaz de usuario.</li>
						<li><strong>Herramientas de prototipado:</strong> Permiten crear prototipos interactivos para probar y evaluar el diseño.</li>
						<li><strong>Herramientas de usabilidad:</strong> Permiten realizar pruebas de usabilidad y recopilar datos sobre el comportamiento de los usuarios.</li>
						<li><strong>Herramientas de análisis:</strong> Permiten analizar el comportamiento de los usuarios en el producto o servicio real.</li>
						</ul>
						<p><strong>Ejemplos de buena UX</strong></p>
						<p>Algunos ejemplos de productos o servicios con una buena UX incluyen:</p>
						<ul>
						<li><strong>Google Search:</strong> Su interfaz simple y intuitiva permite a los usuarios encontrar información de manera rápida y fácil.</li>
						<li><strong>Netflix:</strong> Su sistema de recomendaciones personalizado y su interfaz fácil de usar hacen que sea una experiencia muy agradable para los usuarios.</li>
						<li><strong>Transferwise:</strong> Su proceso de transferencia de dinero simple y transparente hace que sea una opción popular para enviar dinero internacionalmente.</li>
						<li><strong>Airbnb:</strong> Su plataforma intuitiva y sus fotos atractivas facilitan la búsqueda y reserva de alojamiento.</li>
						</ul>
						<h2>El futuro de la UX</h2>
						<p>La UX seguirá evolucionando a medida que las tecnologías avancen y las expectativas de los usuarios cambien. Algunas tendencias que se esperan en el futuro de la UX incluyen:</p>
						<ul>
						<li><strong>UX personalizada:</strong> Las experiencias UX se personalizarán cada vez más en función de las necesidades, preferencias y comportamientos individuales de cada usuario.</li>
						<li><strong>UX basada en la voz:</strong> La interacción con los productos y servicios se realizará cada vez más a través de comandos de voz.</li>
						<li><strong>UX basada en gestos:</strong> La interacción con los productos y servicios se realizará cada vez más a través de gestos y movimientos corporales.</li>
						<li><strong>UX inmersiva:</strong> Las experiencias UX se volverán más inmersivas utilizando tecnologías como la realidad virtual y la realidad aumentada.</li>
						</ul>
						<p><strong>En conclusión, la Experiencia de Usuario es un aspecto fundamental para el éxito de cualquier producto o servicio digital. Al enfocarse en las necesidades y expectativas de los usuarios, y siguiendo los principios y procesos de diseño UX, se pueden crear experiencias que sean usables, útiles, accesibles, estéticas, emocionantes y que generen satisfacción en los usuarios.</strong></p>
						""","UX.png",
				"ceyKwU8egNk",
				room4, 300L,DifficultyLevel.SEMI_SENIOR,45,u5,tr2,null, true);
		Keynote keynote4 = new Keynote(4L, "Ciberseguridad",
				"Ciberseguridad, protegiendo el mundo digital contra accesos no autorizados, ataques y fraudes",
				"""
						<p><strong>Ciberseguridad: Protegiendo tu mundo digital</strong></p>
						<p>La Ciberseguridad es la práctica de proteger sistemas, redes y datos de ataques digitales. Estos ataques pueden tener como objetivo robar información confidencial, interrumpir el funcionamiento de un sistema o incluso causar daños físicos. La Ciberseguridad es importante para todos, desde individuos y empresas hasta gobiernos e instituciones.</p>
						<p><strong>¿Por qué es importante la Ciberseguridad?</strong></p>
						<ul>
						<li><strong>Protege la información confidencial:</strong> La información confidencial, como datos personales, información financiera y propiedad intelectual, puede ser robada por ciberdelincuentes y utilizada para fines ilícitos. La Ciberseguridad ayuda a proteger esta información y a mantenerla segura.</li>
						<li><strong>Mantiene el funcionamiento de los sistemas:</strong> Los ataques cibernéticos pueden interrumpir el funcionamiento de los sistemas, lo que puede causar pérdidas económicas y otros daños. La Ciberseguridad ayuda a proteger los sistemas contra estos ataques y a mantenerlos funcionando correctamente.</li>
						<li><strong>Reduce el riesgo de fraude:</strong> Los ciberdelincuentes pueden utilizar ataques cibernéticos para cometer fraude, como el robo de identidad o el fraude financiero. La Ciberseguridad ayuda a reducir el riesgo de ser víctima de estos delitos.</li>
						<li><strong>Protege la reputación:</strong> Los ataques cibernéticos pueden dañar la reputación de una empresa u organización. La Ciberseguridad ayuda a proteger la reputación y a mantener la confianza de los clientes y socios.</li>
						</ul>
						<p><strong>¿Cuáles son las amenazas a la Ciberseguridad?</strong></p>
						<ul>
						<li><strong>Malware:</strong> El malware es un software malicioso que puede dañar un sistema informático o robar información. Algunos tipos comunes de malware incluyen virus, gusanos, troyanos y ransomware.</li>
						<li><strong>Phishing:</strong> El phishing es una técnica de ingeniería social que se utiliza para engañar a las personas para que revelen información confidencial, como contraseñas o datos bancarios. Los ciberdelincuentes suelen enviar correos electrónicos o mensajes de texto falsos que parecen provenir de una fuente legítima.</li>
						<li><strong>Hacking:</strong> El hacking es el acto de acceder ilegalmente a un sistema informático o red. Los hackers pueden utilizar esta información para robar datos, instalar malware o interrumpir el funcionamiento del sistema.</li>
						<li><strong>Ataques de denegación de servicio (DDoS):</strong> Los ataques DDoS se utilizan para sobrecargar un sistema informático o red con tráfico, lo que hace que sea inaccesible para los usuarios legítimos.</li>
						</ul>
						<p><strong>¿Cómo protegerse de las amenazas a la Ciberseguridad?</strong></p>
						<ul>
						<li><strong>Utilizar contraseñas seguras y únicas:</strong> Utilice contraseñas fuertes y únicas para todas sus cuentas en línea. No utilice la misma contraseña para varias cuentas.</li>
						<li><strong>Mantener su software actualizado:</strong> Mantenga su software operativo, antivirus y otras aplicaciones de seguridad actualizadas con los últimos parches.</li>
						<li><strong>Tenga cuidado con lo que hace clic:</strong> No haga clic en enlaces ni abra archivos adjuntos de correos electrónicos o mensajes de texto de personas desconocidas.</li>
						<li><strong>Sea consciente de las estafas de phishing:</strong> No revele información confidencial, como contraseñas o datos bancarios, a través de correos electrónicos o mensajes de texto.</li>
						<li><strong>Tenga cuidado con lo que comparte en línea:</strong> No comparta información personal sensible en línea, como su dirección de casa o número de teléfono.</li>
						<li><strong>Utilice una red Wi-Fi segura:</strong> Cuando use una red Wi-Fi pública, asegúrese de que esté protegida con una contraseña.</li>
						<li><strong>Realice copias de seguridad de sus datos:</strong> Realice copias de seguridad de sus datos regularmente en caso de que su sistema sea infectado con malware o se pierda o dañe.</li>
						</ul>
						<p><strong>Recursos para la Ciberseguridad</strong></p>
						<p>Existen muchos recursos disponibles para ayudarlo a protegerse de las amenazas a la Ciberseguridad. Algunos de estos recursos incluyen:</p>
						""","cibersecurity_2.png", "SZlnyFujkGE",
				room3, 150L,DifficultyLevel.SENIOR,50,u3,tr4,null, true);
		Keynote keynote5 = new Keynote(5L, "Cloud Computing",
				"Cloud Computing: desarrollo y avances en la computación en la nube",
				"""
						<p>La Computación en la Nube, también conocida como servicios en la nube, informática en la nube, nube de cómputo o simplemente "la nube", es un modelo de prestación de servicios de tecnología que ofrece acceso a recursos informáticos, como servidores, almacenamiento, bases de datos, redes y software, a través de Internet. En lugar de invertir en hardware y software físico, las empresas y usuarios pueden acceder a estos recursos de manera remota, pagando solo por lo que usan.</p>
						<p><strong>¿Cómo funciona la Computación en la Nube?</strong></p>
						<ul>
						<li>Los proveedores de servicios en la nube, como Amazon Web Services (AWS), Microsoft Azure y Google Cloud Platform (GCP), operan grandes centros de datos con miles de servidores y otros recursos informáticos.</li>
						<li>Estos recursos se dividen en pequeñas unidades que se pueden alquilar a los usuarios a través de Internet.</li>
						<li>Los usuarios pueden acceder a estos recursos utilizando un navegador web o una aplicación de software.</li>
						</ul>
						<h4>¿Cuáles son los tipos de servicios de Computación en la Nube?</h4>
						<ul>
						<li><strong>Infraestructura como Servicio (IaaS):</strong> IaaS proporciona a los usuarios acceso a recursos informáticos básicos, como servidores, almacenamiento y redes. Los usuarios pueden configurar y administrar estos recursos como si fueran su propia infraestructura física.</li>
						<li><strong>Plataforma como Servicio (PaaS):</strong> PaaS proporciona a los desarrolladores una plataforma para crear, implementar y ejecutar aplicaciones. La plataforma se encarga de la infraestructura subyacente, lo que permite a los desarrolladores enfocarse en el desarrollo de aplicaciones.</li>
						<li><strong>Software como Servicio (SaaS):</strong> SaaS proporciona a los usuarios acceso a aplicaciones de software que se ejecutan en la nube. Los usuarios no necesitan instalar ni administrar el software, simplemente pueden acceder a él a través de un navegador web o una aplicación móvil.</li>
						</ul>
						<p><strong>¿Cuáles son las ventajas de la Computación en la Nube?</strong></p>
						<ul>
						<li><strong>Escalabilidad:</strong> La nube puede escalarse fácilmente para adaptarse a las necesidades cambiantes de una empresa. Los recursos adicionales se pueden provisionar rápidamente y sin necesidad de grandes inversiones en hardware y software.</li>
						<li><strong>Flexibilidad:</strong> La nube ofrece una gran flexibilidad en cuanto a la forma en que se utilizan los recursos informáticos. Los usuarios pueden elegir los servicios que necesitan y pagar solo por lo que usan.</li>
						<li><strong>Costo-efectividad:</strong> La nube puede ayudar a las empresas a reducir sus costos de TI al eliminar la necesidad de comprar y mantener hardware y software físico.</li>
						<li><strong>Accesibilidad:</strong> La nube ofrece acceso a los recursos informáticos desde cualquier lugar con una conexión a Internet. Esto permite a los empleados trabajar de forma remota y a las empresas atender a clientes en todo el mundo.</li>
						<li><strong>Confiabilidad:</strong> Los proveedores de servicios en la nube invierten en infraestructura de alta disponibilidad para garantizar que sus servicios estén siempre disponibles.</li>
						</ul>
						<p><strong>¿Cuáles son los riesgos de la Computación en la Nube?</strong></p>
						<ul>
						<li><strong>Seguridad:</strong> Es importante elegir un proveedor de servicios en la nube confiable que pueda garantizar la seguridad de los datos.</li>
						<li><strong>Dependencia del proveedor:</strong> Las empresas dependen del proveedor de servicios en la nube para la disponibilidad de sus recursos informáticos. Si el proveedor experimenta una interrupción del servicio, las empresas pueden verse afectadas.</li>
						<li><strong>Privacidad:</strong> Los datos almacenados en la nube pueden estar sujetos a las leyes y regulaciones del país en el que se encuentra el centro de datos del proveedor.</li>
						</ul>
						<p><strong>¿Cómo elegir un proveedor de servicios en la Nube?</strong></p>
						<p>Al elegir un proveedor de servicios en la nube, es importante considerar los siguientes factores:</p>
						<ul>
						<li><strong>Precio:</strong> Compare los precios de diferentes proveedores y elija el que mejor se adapte a sus necesidades y presupuesto.</li>
						<li><strong>Características:</strong> Elija un proveedor que ofrezca las características y funcionalidades que necesita.</li>
						<li><strong>Seguridad:</strong> Asegúrese de que el proveedor tenga un historial sólido de seguridad y que pueda garantizar la seguridad de sus datos.</li>
						<li><strong>Soporte:</strong> Elija un proveedor que ofrezca un buen soporte al cliente en caso de que tenga algún problema.</li>
						</ul>
						<p><strong>En conclusión, la Computación en la Nube ofrece una serie de ventajas que pueden ayudar a las empresas a mejorar su eficiencia, reducir sus costos y aumentar su competitividad. Sin embargo, es importante ser consciente de los riesgos y elegir un proveedor de servicios en la nube confiable.</strong></p>
						""","cloud_computing3.png", "HYDIDpz8KGc",
				room3, 150L,DifficultyLevel.SENIOR,50,u7,tr4,null, true);

		Keynote keynote6 = new Keynote(6L, "Blockchain",
				"Blockchain: Transparencia y seguridad en las transacciones",
				"""
						<p>La Computación en la Nube, también conocida como servicios en la nube, informática en la nube, nube de cómputo o simplemente "la nube", es un modelo de prestación de servicios de tecnología que ofrece acceso a recursos informáticos, como servidores, almacenamiento, bases de datos, redes y software, a través de Internet. En lugar de invertir en hardware y software físico, las empresas y usuarios pueden acceder a estos recursos de manera remota, pagando solo por lo que usan.</p>
						<p><strong>¿Cómo funciona la Computación en la Nube?</strong></p>
						<ul>
						<li>Los proveedores de servicios en la nube, como Amazon Web Services (AWS), Microsoft Azure y Google Cloud Platform (GCP), operan grandes centros de datos con miles de servidores y otros recursos informáticos.</li>
						<li>Estos recursos se dividen en pequeñas unidades que se pueden alquilar a los usuarios a través de Internet.</li>
						<li>Los usuarios pueden acceder a estos recursos utilizando un navegador web o una aplicación de software.</li>
						</ul>
						<h4>¿Cuáles son los tipos de servicios de Computación en la Nube?</h4>
						<ul>
						<li><strong>Infraestructura como Servicio (IaaS):</strong> IaaS proporciona a los usuarios acceso a recursos informáticos básicos, como servidores, almacenamiento y redes. Los usuarios pueden configurar y administrar estos recursos como si fueran su propia infraestructura física.</li>
						<li><strong>Plataforma como Servicio (PaaS):</strong> PaaS proporciona a los desarrolladores una plataforma para crear, implementar y ejecutar aplicaciones. La plataforma se encarga de la infraestructura subyacente, lo que permite a los desarrolladores enfocarse en el desarrollo de aplicaciones.</li>
						<li><strong>Software como Servicio (SaaS):</strong> SaaS proporciona a los usuarios acceso a aplicaciones de software que se ejecutan en la nube. Los usuarios no necesitan instalar ni administrar el software, simplemente pueden acceder a él a través de un navegador web o una aplicación móvil.</li>
						</ul>
						<p><strong>¿Cuáles son las ventajas de la Computación en la Nube?</strong></p>
						<ul>
						<li><strong>Escalabilidad:</strong> La nube puede escalarse fácilmente para adaptarse a las necesidades cambiantes de una empresa. Los recursos adicionales se pueden provisionar rápidamente y sin necesidad de grandes inversiones en hardware y software.</li>
						<li><strong>Flexibilidad:</strong> La nube ofrece una gran flexibilidad en cuanto a la forma en que se utilizan los recursos informáticos. Los usuarios pueden elegir los servicios que necesitan y pagar solo por lo que usan.</li>
						<li><strong>Costo-efectividad:</strong> La nube puede ayudar a las empresas a reducir sus costos de TI al eliminar la necesidad de comprar y mantener hardware y software físico.</li>
						<li><strong>Accesibilidad:</strong> La nube ofrece acceso a los recursos informáticos desde cualquier lugar con una conexión a Internet. Esto permite a los empleados trabajar de forma remota y a las empresas atender a clientes en todo el mundo.</li>
						<li><strong>Confiabilidad:</strong> Los proveedores de servicios en la nube invierten en infraestructura de alta disponibilidad para garantizar que sus servicios estén siempre disponibles.</li>
						</ul>
						<p><strong>¿Cuáles son los riesgos de la Computación en la Nube?</strong></p>
						<ul>
						<li><strong>Seguridad:</strong> Es importante elegir un proveedor de servicios en la nube confiable que pueda garantizar la seguridad de los datos.</li>
						<li><strong>Dependencia del proveedor:</strong> Las empresas dependen del proveedor de servicios en la nube para la disponibilidad de sus recursos informáticos. Si el proveedor experimenta una interrupción del servicio, las empresas pueden verse afectadas.</li>
						<li><strong>Privacidad:</strong> Los datos almacenados en la nube pueden estar sujetos a las leyes y regulaciones del país en el que se encuentra el centro de datos del proveedor.</li>
						</ul>
						<p><strong>¿Cómo elegir un proveedor de servicios en la Nube?</strong></p>
						<p>Al elegir un proveedor de servicios en la nube, es importante considerar los siguientes factores:</p>
						<ul>
						<li><strong>Precio:</strong> Compare los precios de diferentes proveedores y elija el que mejor se adapte a sus necesidades y presupuesto.</li>
						<li><strong>Características:</strong> Elija un proveedor que ofrezca las características y funcionalidades que necesita.</li>
						<li><strong>Seguridad:</strong> Asegúrese de que el proveedor tenga un historial sólido de seguridad y que pueda garantizar la seguridad de sus datos.</li>
						<li><strong>Soporte:</strong> Elija un proveedor que ofrezca un buen soporte al cliente en caso de que tenga algún problema.</li>
						</ul>
						<p><strong>En conclusión, la Computación en la Nube ofrece una serie de ventajas que pueden ayudar a las empresas a mejorar su eficiencia, reducir sus costos y aumentar su competitividad. Sin embargo, es importante ser consciente de los riesgos y elegir un proveedor de servicios en la nube confiable.</strong></p>
						""","blockchain.png", "Yn8WGaO__ak",
				room3, 150L,DifficultyLevel.SENIOR,50,u2,tr2,null, true);
		Keynote keynote7 = new Keynote(7L, "Big Data",
				"Big Data: Descifrando el poder de los datos",
				"""
						<p><strong>Big Data: Un océano de información para tomar decisiones inteligentes</strong></p>
						<p>Big Data, o datos masivos en español, se refiere al conjunto de datos extremadamente grandes y complejos que superan la capacidad de procesamiento y almacenamiento de las herramientas tradicionales de gestión de bases de datos. Estos datos provienen de diversas fuentes, como transacciones online, redes sociales, sensores, dispositivos móviles y registros médicos. Su volumen, variedad y velocidad de crecimiento plantean nuevos desafíos y oportunidades para las empresas y organizaciones.</p>
						<h4>¿Por qué es importante Big Data?</h4>
						<ul>
						<li><strong>Tomar decisiones mejor informadas:</strong> Basadas en información real y detallada, las empresas pueden optimizar procesos, mejorar la segmentación de clientes, desarrollar nuevos productos y servicios, y anticiparse a las tendencias del mercado.</li>
						<li><strong>Aumentar la eficiencia operativa:</strong> El análisis de Big Data permite identificar áreas de ineficiencia y optimizar el uso de recursos, reduciendo costos y mejorando la productividad.</li>
						<li><strong>Mejorar la experiencia del cliente:</strong> Analizando el comportamiento y las preferencias de los clientes, las empresas pueden personalizar sus ofertas y brindar una experiencia de cliente más satisfactoria.</li>
						<li><strong>Gestionar riesgos de forma proactiva:</strong> Big Data permite identificar patrones de riesgo y predecir posibles problemas con mayor precisión, facilitando la toma de decisiones preventivas.</li>
						</ul>
						<p><strong>¿Cuáles son los desafíos de Big Data?</strong></p>
						<ul>
						<li><strong>Volumen:</strong> La gestión y almacenamiento de grandes volúmenes de datos requiere infraestructura y tecnologías específicas para su procesamiento y análisis.</li>
						<li><strong>Variedad:</strong> La información proviene de fuentes heterogéneas, con formatos y estructuras diferentes, lo que dificulta su integración y análisis.</li>
						<li><strong>Velocidad:</strong> Los datos se generan y actualizan constantemente, por lo que se necesitan herramientas capaces de procesarlos en tiempo real o casi real.</li>
						<li><strong>Seguridad y privacidad:</strong> Garantizar la seguridad de los datos y la privacidad de las personas es crucial en el entorno Big Data.</li>
						<li><strong>Habilidades y talento:</strong> Analizar e interpretar Big Data requiere profesionales con habilidades específicas en estadística, análisis de datos y aprendizaje automático.</li>
						</ul>
						<p><strong>En conclusión, Big Data es una realidad que transforma el panorama empresarial y organizacional. Su capacidad para extraer información valiosa de grandes volúmenes de datos abre un sinfín de oportunidades para la toma de decisiones estratégicas, la mejora de la eficiencia y la innovación. Sin embargo, es necesario abordar los desafíos técnicos y de gestión para aprovechar todo su potencial de forma segura y responsable.</strong></p>
						""","big_data_2.png", "eXMaoSEYrso",
				room3, 150L,DifficultyLevel.SENIOR,50,u3,tr2,null, true);
		Keynote keynote8 = new Keynote(8L, "Internet de las cosas (IoT)",
				"IoT: Un mundo conectado",
				"""
						<p><strong>Internet de las Cosas (IoT): Conectando el mundo físico al digital</strong></p>
						<p>El Internet de las Cosas (IoT), también conocido como la red de objetos, es una red de objetos físicos o "cosas" incrustadas con sensores, software y conectividad a internet para recopilar y compartir datos. Estos objetos, que pueden ser desde electrodomésticos inteligentes hasta dispositivos portátiles, se conectan entre sí y con la internet para intercambiar información y tomar decisiones. El IoT permite crear entornos inteligentes y automatizados que pueden mejorar la eficiencia, la productividad y la calidad de vida.</p>
						<p><strong>¿Cómo funciona el Internet de las Cosas (IoT)?</strong></p>
						<ul>
						<li><strong>Sensores:</strong> Los objetos físicos recopilan datos del entorno a través de sensores integrados. Estos datos pueden incluir temperatura, humedad, movimiento, ubicación, etc.</li>
						<li><strong>Conectividad:</strong> Los objetos transmiten los datos recopilados a través de redes inalámbricas, como Wi-Fi, Bluetooth o redes celulares.</li>
						<li><strong>Procesamiento y análisis de datos:</strong> Los datos recopilados se envían a la nube o a servidores locales para su procesamiento y análisis.</li>
						<li><strong>Acciones y decisiones:</strong> En base a los datos analizados, se pueden tomar decisiones o realizar acciones automatizadas.</li>
						</ul>
						<p><strong>¿Cuáles son los beneficios del Internet de las Cosas (IoT)?</strong></p>
						<ul>
						<li><strong>Eficiencia:</strong> El IoT permite automatizar tareas repetitivas y optimizar procesos, lo que reduce costos y aumenta la productividad.</li>
						<li><strong>Comodidad:</strong> El IoT facilita la vida cotidiana al automatizar tareas domésticas, controlar dispositivos inteligentes y brindar acceso remoto a información.</li>
						<li><strong>Seguridad:</strong> El IoT puede mejorar la seguridad en hogares, empresas y ciudades a través de sistemas de monitoreo y alerta temprana.</li>
						<li><strong>Sostenibilidad:</strong> El IoT puede contribuir a la sostenibilidad ambiental mediante el uso eficiente de recursos y la reducción del consumo energético.</li>
						<li><strong>Nuevos servicios y modelos de negocio:</strong> El IoT abre posibilidades para el desarrollo de nuevos servicios y modelos de negocio basados en datos y análisis.</li>
						</ul>
						<p><strong>¿Cuáles son los desafíos del Internet de las Cosas (IoT)?</strong></p>
						<ul>
						<li><strong>Seguridad y privacidad:</strong> La seguridad de los datos y la privacidad de los usuarios son aspectos cruciales que deben garantizarse en el IoT.</li>
						<li><strong>Interoperabilidad:</strong> La falta de estandarización en los protocolos y tecnologías puede dificultar la comunicación entre dispositivos de diferentes fabricantes.</li>
						<li><strong>Escalabilidad:</strong> La gestión de grandes volúmenes de datos y la capacidad de procesamiento de la infraestructura son desafíos que deben superarse para el crecimiento del IoT.</li>
						<li><strong>Impacto social:</strong> El IoT puede generar cambios en el mercado laboral y en la forma en que las personas interactúan con el mundo, por lo que es importante considerar su impacto social y ético.</li>
						</ul>
						<p><strong>En conclusión, el Internet de las Cosas (IoT) es una tecnología revolucionaria con el potencial de transformar diversos aspectos de nuestra vida. Sus beneficios en términos de eficiencia, comodidad, seguridad, sostenibilidad e innovación son significativos. Sin embargo, es importante abordar los desafíos relacionados con la seguridad, la privacidad, la interoperabilidad, la escalabilidad y el impacto social para garantizar un desarrollo responsable y sostenible del IoT.</strong></p>
						""","IoT.png", "OcS2IauiIaQ",
				room3, 150L,DifficultyLevel.SENIOR,50,u5,tr5,null, true);
//		Keynote keynote9 = Keynote.builder()
//				.title("VISITE NUESTRA CAFETERIA").photoUrl("Cafeteria.jpeg")
//						.durationInMin(30).maxNumPersons(300L).track(tr3)
//						.build();

//				new Keynote(9L, ,
//				null,
//				null,, null,
//				null, null,null,null,null,tr3,null);
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