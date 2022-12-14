package test;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component		// quando spring vede l'annotazione, si crea la descrizione di un nuovo bean in base alle annotazioni della classe
public class Calcolatrice {

	public Calcolatrice(@Value("5") int base) {
		System.out.println("creo la calcolatrice di base: " + base);
	}
}
