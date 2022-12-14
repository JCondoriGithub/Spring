package springhello;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.DisposableBean;

@Component("utenteProva")
@Scope("prototype")
public class User implements InitializingBean, DisposableBean {

	@Value("user1")		// il valore di "login" sarà il seguente
	private String login;
	
	private String password, name, surname;
	
	@Autowired
	private Group group;

	public User() {

	}

	public User(String login, String password, String name, String surname) {

		this.login = login;
		this.password = password;
		this.name = name;
		this.surname = surname;
	}
	
	public User(String name, Group group) {
		this.name = name;
		this.group = group;
	}
	
	public static User createInstance(String name, Group group) {
		return new User(name, group);
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("afterPropertiesSet_User");
	}
	
	@Override
	public void destroy() throws Exception {
		System.out.println("destroy");		
	}
	
	public void myInit() {
		System.out.println("myInit");
	}
	
	public void myDestroy() {
		System.out.println("myDestroy");
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	@Override
	public String toString() {
		return "User [login=" + login + ", password=" + password + ", name=" + name + ", surname=" + surname
				+ ", group=" + group + "]";
	}
	
}
