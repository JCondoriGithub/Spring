package springboot.hello;

import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
public class Calcolatrice {

	public int add(int x, int y) {
		return x + y;
	}
	
	@PostConstruct
	public void init() {
		System.out.println("metodo PostConstruct di: " + this);
	}
}
