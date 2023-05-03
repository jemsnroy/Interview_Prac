package Session4;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class ResponseBodyTest {
	
	// This tests is working perfectly fine.
	
	//Approach 1:
	
	  @Test (priority = 1)
	  void validateResponseBody() {
	  
	  
	  given() .contentType(ContentType.JSON)
	  
	  .when() .get("  http://localhost:3000/store")
	  
	  
	  .then() .statusCode(200) .header("Content-Type",
	  "application/json; charset=utf-8") .body("book[2].title",
	  equalTo("Manual Tester")) .log().all();
	  
	  
	  }
	 
	
	
	  @Test (priority = 2)void validateResponseBodyByJSONPath() {
	  
	  
	  Response res = given() .contentType("application/json")
	  
	  .when() .get("  http://localhost:3000/store");
	  
	  Assert.assertEquals(res.statusCode(), 200);
	  Assert.assertEquals(res.getHeader("Content-Type"),
	  "application/json; charset=utf-8");
	  
	  String value =res.jsonPath().get("book[2].title").toString();
	  Assert.assertEquals(value, "Manual Tester");
	  
	  
	  
	  }
	 
	
	//Approach 2:
	@Test(priority = 3)
	void validateMultipleValuesfromResponseBody() {
		
		Response res = given()
				.contentType(ContentType.JSON)
				
				.when()
				.get("  http://localhost:3000/store");
		
		JSONObject jo = new JSONObject(res.asString());
		
		boolean flag = false;
		for(int i = 0; i < jo.getJSONArray("book").length(); i++) {
			
			String authorName = jo.getJSONArray("book").getJSONObject(i).get("author").toString();
			System.out.println(authorName);
			
			if(authorName.contains("Jemish")) {
				flag = true;
				break;
			}
			
		}
		Assert.assertEquals(flag, true);
		
	}
		
		@Test(priority = 3)
		void validateAdditonOfMultipleValuesfromResponseBody() {
			
			Response res = given()
					.contentType(ContentType.JSON)
					
					.when()
					.get("  http://localhost:3000/store");
			
			JSONObject jo = new JSONObject(res.asString());
			double d = 0;
			for(int i = 0; i < jo.getJSONArray("book").length(); i++) {
				
				String authorName = jo.getJSONArray("book").getJSONObject(i).get("price").toString();
				d = d + Double.parseDouble(authorName);
				
				
				
			}
			System.out.println(d);
		
		
		
	}
	
	
	
	

}
