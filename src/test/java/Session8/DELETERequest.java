package Session8;

import static io.restassured.RestAssured.given;

import org.testng.ITestContext;
import org.testng.annotations.Test;

public class DELETERequest {
	
	@Test
	void deleteUser(ITestContext context) {
		
String bearerToken = "fe1ee6b3262a3f91a919c8f190ab2c058723bb9c0289b5593c9259906f0a2f20";
		
		int id = (int) context.getSuite().getAttribute("user_id"); // .getSuite() method is for making that variable to accessible to the global level.
		
		given()
		.headers("Authorization", "Bearer "+bearerToken)
		.pathParam("id", id)
		.when()
		.delete("https://gorest.co.in/public/v2/users/{id}")
		.then()
		.statusCode(204)
		.log().all();
		
		
	}

}
