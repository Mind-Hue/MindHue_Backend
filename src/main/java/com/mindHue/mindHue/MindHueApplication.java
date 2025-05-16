package com.mindhue.mindhue;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MindHueApplication {

	public static void main(String[] args) {
		SpringApplication.run(MindHueApplication.class, args);
		System.out.println("Conexión exitosa!!");
	}

}
