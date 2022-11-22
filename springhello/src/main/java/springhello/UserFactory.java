package springhello;

public class UserFactory {

	public User createUser(String name, Group group) {
		
		User u = new User(name, group);
		u.setSurname("ignoto");
		return u;
	}
}
