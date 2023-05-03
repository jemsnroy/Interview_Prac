package Session3;
import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;
public class PathAndQueryPara {
	
	
	//https://reqres.in/api/users?page=2
	
	@Test
	void getUser() {
		
		given()
		.pathParam("path", "users")
		.queryParam("page", 2)
		
		
		.when()
		.get("https://reqres.in/api/{path}")
		
		.then()
		.statusCode(200)
		.log().all();
		
	}
	

}
