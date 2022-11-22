package springhello;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

class SpringTest {

	@Test
	void test() {

		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");

		User u1 = ctx.getBean("u1", User.class);
		System.out.println("u1: " + u1);
		
		User u2 = ctx.getBean("u2", User.class);
		System.out.println("u2: " + u2);
		
		ctx.close();
	}
}
