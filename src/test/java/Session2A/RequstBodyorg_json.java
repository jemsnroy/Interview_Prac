package Session2A;

import static io.restassured.RestAssured.given;

import org.json.JSONObject;
import org.testng.annotations.Test;

public class RequstBodyorg_json {
	int id;

	@Test(priority = 1)
	void postUser() {

		JSONObject data = new JSONObject();

		data.put("name", "Jeman");
		data.put("Phone", "1234");

		String courseArray[] = { "Java", "Selenium" };
		data.put("courses", courseArray);

		id = given()
				.contentType("application/json")
				.body(data.toString())

				.when().post(" http://localhost:3000/students")
				.jsonPath().getInt("id");

		/*
		 * .then() .statusCode(201) .body("name", equalTo("Jeman")) .body("courses[0]",
		 * equalTo("Java")) .body("courses[1]", equalTo("Selenium"))
		 * .header("Content-Type", "application/json; charset=utf-8") .log().all();
		 */
	}

	@Test(priority = 2, dependsOnMethods = "postUser")
	void deleteUser() {

		given()

				.when().delete("http://localhost:3000/students/" + id).then().statusCode(200)

				.log().all();
	}

}
