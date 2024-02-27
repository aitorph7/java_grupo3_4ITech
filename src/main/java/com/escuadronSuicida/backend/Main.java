package com.escuadronSuicida.backend;

import com.escuadronSuicida.backend.models.Room;
import com.escuadronSuicida.backend.models.User;
import com.escuadronSuicida.backend.models.UserRole;
import com.escuadronSuicida.backend.repository.RoomRepository;
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
		RoomRepository roomRepository = context.getBean(RoomRepository.class);

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
	}


}
