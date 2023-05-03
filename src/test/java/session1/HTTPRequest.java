package session1;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.HashMap;

import org.testng.annotations.Test;

public class HTTPRequest {

	int id;

	@Test(priority = 1)

	void getUsers() {

		given()

				.when().get("https://reqres.in/api/users?page=2")

				.then().statusCode(200).body("page", equalTo(2)).log().all();
	}

	
	  @Test void postUser() {
	  
	  HashMap<String, String> hm = new HashMap<>(); 
	  hm.put("name", "Jemish");
	  hm.put("job", "QA");
	  
	  given()
	  .contentType("application/json")
	  .body(hm)
	  
	  .when()
	  .post("https://reqres.in/api/users")
	  
	  .then().statusCode(201).body("name", equalTo("Jemish")).log().all(); }
	 
	//@Test(priority = 2)
	void postUser1() {

		HashMap<String, String> hm = new HashMap<>();
		hm.put("name", "Jemish");
		hm.put("job", "QA");

		id = given().contentType("application/json").body(hm)

		.when().post("https://reqres.in/api/users").jsonPath().getInt("id");
	}

	//@Test(priority = 3, dependsOnMethods = { "postUser" })
	void updateUser() {
		HashMap<String, String> hm = new HashMap<>();
		hm.put("name", "Mansi");
		hm.put("job", "Developer");
		given().contentType("application/json").body(hm)
		
		.when().put("https://reqres.in/api/users/" + id)
		
		.then().statusCode(200).body("name", equalTo("Mansi")).log().all();
	}

	//@Test(priority = 4, dependsOnMethods = { "postUser" })
	void deleteUser() {

		given()
		
		.when().delete("https://reqres.in/api/users/" + id)
		
		.then().statusCode(204).log().all();

	}

}
