package test;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
@Configuration
public class TestFactory {

	@Bean("beanDaFactory")		// si indica che questo metodo restituisce in bean di nome "beanDaFactory", quindi spring eseguirà il metodo
	public ClasseInLibreria crea() {
		System.out.println("chiamo il metodo 'crea' di TestFactory");
		return new ClasseInLibreria("sono una classe non accesibile facilmente...");
	}
}
