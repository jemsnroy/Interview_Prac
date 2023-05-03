package Session2A;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.HashMap;

import org.testng.annotations.Test;

public class RequstBodyHashMap {

	@Test
	void postUser() {

		HashMap<Object, Object> data = new HashMap<>();
		data.put("name", "Mansi");
		data.put("Phone", "1234");

		/*
		 * String courseArray[] = { "Java", "Csharp" };
		 * System.out.println(courseArray.length); System.out.println(courseArray[0]);
		 */
		data.put("courses", "Java");

		given()
		.contentType("application/json")
		.body(data)

		.when()
		.post(" http://localhost:3000/students")
		
		.then()
		.statusCode(201)
		.body("name", equalTo("Mansi"))
		.header("Content-Type", "application/json; charset=utf-8")
		.log().all();
	
	}
	
	
	@Test
	void deleteUser() {
		
		given()
		
		
		.when()
		.delete("http://localhost:3000/students/14")
		.then()
		.statusCode(200)
		
		.log().all();
	}

}
