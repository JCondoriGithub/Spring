package springboot.hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication		// indica come annotazione anche @Component e @Configuration -> quindi è possibile inserire dei metodi-factory
public class SpboothelloApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpboothelloApplication.class, args);	// nel metodo "run" vi è la creazione dello spring context/container per le annotazioni ed è configurato per cercare i bean i bean sul package in cui si trova la classe messo come parametro
	}																// "SpringApplication" è l'entrypoint di springboot. "SpboothelloApplication" è l'entrypoint della mia app

}
