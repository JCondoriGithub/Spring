package springhello;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.DisposableBean;

public class User implements InitializingBean, DisposableBean {

	private String login, password, name, surname;
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

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("afterPropertiesSet");
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
