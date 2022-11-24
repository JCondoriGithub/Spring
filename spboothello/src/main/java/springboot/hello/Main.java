package springboot.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Main implements CommandLineRunner {	// springboot crea il container, recupera i bean che implementano l'interfaccia e invoca il loro metodo "run"

	@Autowired
	Calcolatrice calc;	// si innietta l'implementazione di "Calcolatrice". Quella che ha l'annotazione @Primary o tramite @Qualifier
	
	@Override
	public void run(String... args) throws Exception {

		System.out.println("eseguo il metodo run della classe Main");
		
		int x = 9, y = 10;
		System.out.println("risultato: " + calc.add(x, y));
	}

	
}
