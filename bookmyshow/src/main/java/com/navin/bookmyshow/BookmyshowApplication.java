package com.navin.bookmyshow;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.navin.bookmyshow.controlllers.UserController;
import com.navin.bookmyshow.dtos.SignUpRequestDTO;
import com.navin.bookmyshow.dtos.SignUpResponseDTO;

@SpringBootApplication
@EnableJpaAuditing
public class BookmyshowApplication implements CommandLineRunner {
	@Autowired
	private UserController userController;

	@Override
	public void run(String... args) throws Exception {
		SignUpRequestDTO signUpRequestDTO = new SignUpRequestDTO();
		signUpRequestDTO.setEmail("sandula.navin@scaler.com");
		signUpRequestDTO.setPassword("password");
		SignUpResponseDTO response = userController.signUp(signUpRequestDTO);
	}

	public static void main(String[] args) {
		SpringApplication.run(BookmyshowApplication.class, args);
	}

}
