package Session2A;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

public class RequestBodyExistingJSONfile {

	@Test
	void postUser() throws FileNotFoundException {

		File f = new File("D:\\Selenium_Practice\\APITesting\\requestBody.json");

		FileReader fr = new FileReader(f);

		JSONTokener jt = new JSONTokener(fr);

		JSONObject data = new JSONObject(jt);

		given().contentType("application/json").body(data.toString())

				.when()
				.post("http://localhost:3000/students")
				.then()
				.statusCode(201)
				.body("name", equalTo("Sarang"))
				.log().all();

	}

	@Test
	void deleteUser() {
		
		given()
		
		
		.when()
		.delete("http://localhost:3000/students/30")
		.then()
		.statusCode(200)
		
		.log().all();
	}
}
