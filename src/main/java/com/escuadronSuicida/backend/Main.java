package com.escuadronSuicida.backend;

import com.escuadronSuicida.backend.models.Comment;
import com.escuadronSuicida.backend.models.User;
import com.escuadronSuicida.backend.models.UserRole;
import com.escuadronSuicida.backend.repository.CommentRepository;
import com.escuadronSuicida.backend.repository.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class Main {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(Main.class, args);

		UserRepository userRepository = context.getBean(UserRepository.class);
		CommentRepository commentRepository = context.getBean(CommentRepository.class);

		User user1 = new User(null,
				"Pablo",
				"González",
				"pablo@gmail.com",
				"657478901",
				"pablou1",
				"pablou1",
				"callePablo, 2, 28046, Madrid, Madrid",
				UserRole.ATTENDEE,
				null);
		User user2 = new User(null,
				"Oscar",
				"Catalan",
				"oscar@yahoo.es",
				"663501200",
				"oscaru2",
				"oscaru2",
				"calleOscar, 46, 28011, Madrid, Madrid",
				UserRole.ATTENDEE,
				null);
		User user3 = new User(null,
				"Trevor",
				"McIntosh",
				"trevor@apple.com",
				"+1 415-555-1234",
				"trevor@apple.com",
				"trevoru3",
				"1234 TrevorSt, San Francisco, CA 94123, USA",
				UserRole.SPEAKER,
				null);
		User user4 = new User(null,
				"Eutimio",
				"Developer",
				"eutimio@certidevs.com",
				"619567144",
				"eutimmiou4",
				"eutimmiou4",
				"calleEutimio, 23, 28004, Madrid, Madrid",
				UserRole.ADMIN,
				null);
		User user5 = new User(null,
				"Leocadia",
				"Sigüenza",
				"leocadia@hotmail.com",
				"661541094",
				"leocadiau5",
				"leocadiu5",
				"calleLeocadia, 10, 02001, Albacete, Albacete",
				UserRole.ATTENDEE,
				null);
		userRepository.saveAll(List.of(user1, user2, user3, user4, user5));

		Comment c1 = new Comment(null,
				3.0,
				"Fascinante, revelando el increíble potencial creativo " +
						"de las máquinas en la producción de contenido único y original.",
				user1);
		Comment c2 = new Comment(null,
				4.0,
				"me dejó asombrado, destacando cómo la tecnología puede generar " +
						"ideas innovadoras y abrir nuevas posibilidades en el ámbito " +
						"creativo.",
				user2);
		Comment c3 = new Comment(null,
				4.0,
				"fue esclarecedora, mostrando cómo estas avanzadas tecnologías " +
						"están transformando la forma en que concebimos y creamos contenido " +
						"de manera revolucionaria.",
				user5);
		commentRepository.saveAll(List.of(c1, c2, c3));
	}


}
