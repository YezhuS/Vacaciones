package com.capg.capgspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;



@SpringBootApplication(scanBasePackages = "com.capg")
@ComponentScan(basePackages = "com.capg")
@EntityScan("com.capg.models")
@EnableJpaRepositories("com.capg.repositories") 
public class CapgspringApplication {

	public static void main(String[] args) {
		SpringApplication.run(CapgspringApplication.class, args);
		
	}

}






