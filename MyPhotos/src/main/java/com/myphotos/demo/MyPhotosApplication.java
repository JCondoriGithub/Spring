package com.myphotos.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication		// si indica che questa è la classe principale di spring-boot
public class MyPhotosApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyPhotosApplication.class, args);	// come parametro si specifica la classe con l'annotazione @SpringBootApplication e il container recupera i bean delle classi con delle annotazioni
	}

}
