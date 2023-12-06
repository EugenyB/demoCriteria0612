package com.example.demo;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@SpringBootApplication
public class Demo26Application {

	public static void main(String[] args) {
		SpringApplication.run(Demo26Application.class, args);
	}


	@Bean
	public CommandLineRunner run(UserRepository repository) {
		return args -> {
			//addUsers(repository);
			findUsersByEmail(repository);
		};
	}

	private void findUsersByEmail(UserRepository repository) {
		List<User> users = repository.findUserByEmails(Set.of("email@dot.com", "email3@dot.com"));
		users.forEach(System.out::println);
	}

	private void addUsers(UserRepository repository) {
		repository.save(new User("Piter", LocalDate.now(), "email@dot.com", 1));
		repository.save(new User("Jack", LocalDate.now().minusDays(5), "email1@dot.com", 1));
		repository.save(new User("John", LocalDate.now().minusMonths(1), "email2@dot.com", 1));
		repository.save(new User("Mike", LocalDate.now().minusDays(9), "email3@dot.com", 1));
	}
}
