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
		System.out.println("getBean per nome/id: " + u1);
		
		Map<String, User> res = ctx.getBeansOfType(User.class);
		for(User user: res.values()) {
			System.out.println(user);
		}
		
		ctx.close();	// si finalizza il container distruggendo tutti i bean
	}
/*
afterPropertiesSet
myInit
getBean per nome/id: User [login=null, password=null, name=Mario, surname=Rossi]
User [login=null, password=null, name=Mario, surname=Rossi]
destroy
myDestroy
 */
}
