package springboot.hello;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
@Primary	// grazie all'annotazione, è questo bean verra inniettato
public class CalcolatriceImpl2 implements Calcolatrice {

	public int add(int x, int y) {
		System.out.println("calcolo con calcolatrice 2");
		return x + y;
	}
	
	@PostConstruct
	public void init() {
		System.out.println("metodo PostConstruct di: " + this);
	}
}
