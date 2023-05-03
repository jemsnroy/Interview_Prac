package Session6;

import org.testng.annotations.Test;

public class pojoRequest {
	String name;
	String phone;
	String courses[];
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String[] getCourses() {
		return courses;
	}

	public void setCourses(String[] courses) {
		this.courses = courses;
	}

	
	
	@Test
	void postUser() {
		
		
		
	}
}
