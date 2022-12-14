package springhello;

import org.springframework.beans.factory.InitializingBean;

public class Group implements InitializingBean {

	private String name;	
	
	public Group() {
		
	}
	
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("afterPropertiesSet_Group");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Group [name=" + name + "]";
	}

}
