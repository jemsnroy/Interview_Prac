package Session8;

import static io.restassured.RestAssured.given;

import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class POSTRequest {

	int id;
	
	@Test
	void createUser(ITestContext context) {
		
		Faker f = new Faker();
		
		String name = f.name().fullName();
		String email = f.internet().emailAddress();
	
		
		JSONObject jo = new JSONObject();
		jo.put("name", name);
		jo.put("email", email);
		jo.put("gender", "Male");
		jo.put("status", "InActive");
		
		String bearerToken = "fe1ee6b3262a3f91a919c8f190ab2c058723bb9c0289b5593c9259906f0a2f20";
		
		
		id = given()
		.headers("Authorization", "Bearer "+bearerToken)
		.body(jo.toString())
		.contentType("application/json")
		.when()
		.post("https://gorest.co.in/public/v2/users")
		.jsonPath().getInt("id");
		
		System.out.println(id);
		
		context.getSuite().setAttribute("user_id", id); // .getSuite() method is for making that variable to accessible to the global level. 
		/*.then()
		.statusCode(201)
		.body("name", equalTo(name))
		.log().all();*/
		
		
		
	}
	
}
