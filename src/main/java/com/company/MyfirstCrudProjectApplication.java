package com.company;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.time.LocalDateTime;

@SpringBootApplication
@EnableScheduling
public class MyfirstCrudProjectApplication {


	public static void main(String[] args) {SpringApplication.run(MyfirstCrudProjectApplication .class , args);

		System.out.println("This project is created by Mechanical boy"+ LocalDateTime.now());
	}


}
