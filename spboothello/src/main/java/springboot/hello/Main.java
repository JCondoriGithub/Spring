package springboot.hello;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Main implements CommandLineRunner {	// springboot crea il container, recupera i bean che implementano l'interfaccia e invoca il loro metodo "run"

	@Override
	public void run(String... args) throws Exception {

		System.out.println("eseguo il metodo run della classe Main");
	}

	
}
