package Session7;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

public class Authorization {
	
	// Basic, digest, preemptive are almost similar because these all three are based on Username and Password.
	
	@Test(priority = 1)
	void validatebasicAuth() {
		
		given()
		.auth().basic("postman", "password")
		
		.when()
		.get("https://postman-echo.com/basic-auth")
		.then()
		.statusCode(200)
		.body("authenticated", equalTo(true))
		.log().all();
		
		
	}
	
	@Test(priority = 2)
	void validateDigestAuth() {
		
		
		given()
		.auth().digest("postman", "password")
		.when()
		.get("https://postman-echo.com/basic-auth")
		.then()
		.statusCode(200)
		.log().all();
	}
	
	@Test(priority = 3)
	void validatePreemptiveAuth() {
		
		given()
		.auth().preemptive().basic("postman", "password")
		.when()
		.get("https://postman-echo.com/basic-auth")
		.then()
		.statusCode(200)
		.log().all();

	}
	
	@Test(priority = 4)
	void validateBearerToken() {
		
		String token = "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";

		
		given()
		.headers("Authorization","Bearer "+token)
		
		.when()
		.get("https://api.github.com/user/repos")
		.then()
		.statusCode(200)
		.body("[0].name", equalTo("APIRestAssuredProject"))
		.log().all();
		
		
	}
	
	// There is not any example for this authentication.
	//@Test
	void validateOAuth1() {
		
		given()
		.auth().oauth("consumerKey", "consumerSecret", "accessToken", "secretToken")
		.when()
		.get("URI")
		.then()
		.log().all();
	}
	
	//@Test
	void validateOAuth2() {
		
		given()
		.auth().oauth2("accessToken")
		.when()
		.get("URI")
		.then()
		.log().all();
		
	}
	
	//For me this appid is not working otherwise everything is working properly.
	
	//@Test
	void validateAPIAuthentication() {
		
		given()
		
		.queryParam("appid", "c2e21b0e669a5c8b2bb162b39d665bdb")
		.pathParam("mypath", "data/2.5/forecast/daily")
		.queryParam("q", "Delhi")
		.queryParam("units", "metric")
		.queryParam("cnt", "7")
		.when()
		.get("http://api.openweathermap.org/{mypath}")
		.then()
		.statusCode(200)
		.log().all();
		
		
	}
}
