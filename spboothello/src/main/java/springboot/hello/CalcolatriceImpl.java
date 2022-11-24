package springboot.hello;

import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
public class CalcolatriceImpl implements Calcolatrice {

	public int add(int x, int y) {
		return x + y;
	}
	
	@PostConstruct
	public void init() {
		System.out.println("metodo PostConstruct: " + this);
	}
}
