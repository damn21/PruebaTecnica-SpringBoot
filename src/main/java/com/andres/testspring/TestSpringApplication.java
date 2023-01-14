package com.andres.testspring;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class TestSpringApplication implements CommandLineRunner {

	private JdbcTemplate template;

	public static void main(String[] args) {
		SpringApplication.run(TestSpringApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//Creacion de tablas H2
              template.execute("DROP TABLE HEROS IF EXISTS");
			  //template.execute("CREATE TABLE HEROS (id INTEGER(11) PRIMARY KEY auto-increment, name VARCHAR(255))");
	          //template.update("insert into heros(name) values('spiderman'))");
	}
}
