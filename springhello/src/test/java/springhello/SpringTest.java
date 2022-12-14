package springhello;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Map;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import test.Calcolatrice;
import test.ClasseInLibreria;

class SpringTest {

	@Test
	void test() {

		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		AnnotationConfigApplicationContext ctx2 = new AnnotationConfigApplicationContext("test");	// si indica il package delle classi o le classi stesse		
				
		Object classLib = ctx2.getBean("beanDaFactory");
		System.out.println("classe dalla libreria: "+classLib);
		
		ctx.close();
	}
}
