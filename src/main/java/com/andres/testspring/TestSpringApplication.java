package com.andres.testspring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class TestSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestSpringApplication.class, args);
	}

	//@Override
	//public void run(String... args) throws Exception {
		//Creacion de tablas H2
	//	jdbcTemplate.execute("DROP TABLE IF EXISTS HEROE CASCADE");
	//	jdbcTemplate.execute("CREATE TABLE HEROE(id INTEGER(10) PRIMARY KEY auto_increment, name VARCHAR(100))");

	//	for (int i=0; i < 3; i++){
	//		jdbcTemplate.update("insert into heroe(name)values('Heroe "+i+"')");
	//	}
	//}
}
