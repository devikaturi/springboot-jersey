package com.training.devo.springbootjersey;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("com.training.devo.springbootjersey")
@EnableJpaRepositories("com.training.devo.springbootjersey.database.respositories")
public class SpringbootJerseyApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootJerseyApplication.class, args);
	}
}
