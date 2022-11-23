package springhello;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import test.Calcolatrice;

class SpringTest {

	@Test
	void test() {

		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		AnnotationConfigApplicationContext ctx2 = new AnnotationConfigApplicationContext("test");	// si indica il package delle classi o le classi stesse

		/*User u1 = ctx.getBean("u1", User.class);
		System.out.println("u1: " + u1);
		
		User u2 = ctx.getBean("utenteProva", User.class);	// il nome del bean è quello dichiarato in annotazione e imposta le proprietà solo dalle annotazioni
		System.out.println("u2: " + u2);*/
		
		Calcolatrice c = ctx2.getBean(Calcolatrice.class);
		
		ctx.close();
	}
}
