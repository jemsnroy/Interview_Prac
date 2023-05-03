package Session2A;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


public class RequestBodyPOJO {

	@Test
	void postUser() {
		pojoRequest data = new pojoRequest();
		
		data.setName("Kishan");
		data.setPhone("12345");
		
		String coursesArray[] = {"Civil","Engineer"};
		data.setCourses(coursesArray);
		
		given()
		.contentType("application/json")
		.body(data)
		.when()
		.post("http://localhost:3000/students")
		
		.then()
		.statusCode(201)
		.body("name", equalTo("Kishan"))
		.body("courses[0]", equalTo("Civil"))
		.body("courses[1]", equalTo("Engineer"))
		.header("Content-Type", "application/json; charset=utf-8")
		.log().all();
		
	}
	
	@Test
	void deleteUser() {
		
		given()
		
		
		.when()
		.delete("http://localhost:3000/students/25")
		.then()
		.statusCode(200)
		
		.log().all();
	}
	
}
