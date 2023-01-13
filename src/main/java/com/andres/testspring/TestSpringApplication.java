package com.andres.testspring;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TestSpringApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(TestSpringApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//Creacion de tablas H2

	}
}
