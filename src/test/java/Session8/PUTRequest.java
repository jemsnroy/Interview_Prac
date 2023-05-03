package Session8;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;


public class PUTRequest {
	
	
	
	@Test
	void updateUser(ITestContext context) {
		
		
Faker f = new Faker();
		
		String name = f.name().fullName();
		String email = f.internet().emailAddress();
	
		
		JSONObject jo = new JSONObject();
		jo.put("name", name);
		jo.put("email", email);
		jo.put("gender", "Male");
		jo.put("status", "Active");
		
		String bearerToken = "fe1ee6b3262a3f91a919c8f190ab2c058723bb9c0289b5593c9259906f0a2f20";
		
		int id = (int) context.getSuite().getAttribute("user_id"); // .getSuite() method is for making that variable to accessible to the global level.
		
		given()
		.headers("Authorization", "Bearer "+bearerToken)
		.pathParam("id", id)
		.body(jo.toString())
		.contentType("application/json")
		.when()
		.put("https://gorest.co.in/public/v2/users/{id}")
		.then()
		.statusCode(200)
		.body("name", equalTo(name))
		.log().all();
		
	}

}
