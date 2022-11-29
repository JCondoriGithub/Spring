package springboot.hello.web;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import jakarta.annotation.PostConstruct;

@SessionScope	// si indica che questo componente avrà lo scope di tipo sessione, quindi un'istanza per sessione
@Component
public class MySession {

	double id;
	String username;
	
	@PostConstruct		// ogni istanza di "MySession" avrà un "id" diverso
	public void init() {
		id = Math.random();
	}
}
