package com.example.automate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

@EnableAutoConfiguration
@SpringBootApplication(exclude={HibernateJpaAutoConfiguration.class})
public class AutoMateApplication {

	public static void main(String[] args) {
		SpringApplication.run(AutoMateApplication.class, args);
	}

}
