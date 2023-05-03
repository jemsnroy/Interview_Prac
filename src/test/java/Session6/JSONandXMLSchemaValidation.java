package Session6;
import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.matcher.RestAssuredMatchers;
import io.restassured.module.jsv.JsonSchemaValidator;
public class JSONandXMLSchemaValidation {
	
	@Test(priority = 1)
	void validateJSONSchema() {
		
		given()
		
		.when()
		.get(" http://localhost:3000/store")
		.then()
		.assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("JSONSchema.json"))
		.log().all();
		
	}
	@Test(priority = 2)
	void validateXMLSchema() {
		
		given()
		.queryParam("page", 1)
		.when()
		.get(" http://restapi.adequateshop.com/api/Traveler")
		.then()
		.assertThat().body(RestAssuredMatchers.matchesXsdInClasspath("XMLSchema.xsd"))
		.log().all();
		
	}

}
