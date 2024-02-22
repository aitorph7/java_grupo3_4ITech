package com.escuadronSuicida.backend;

import com.escuadronSuicida.backend.repository.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Main {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(Main.class, args);
		UserRepository userRepository = context.getBean(UserRepository.class);
	}

}
