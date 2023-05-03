package Session3;
import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class HeadersTest {
	
	//@Test
	void validateHeader() {
		
		given()
		
		.when()
		.get("https://www.google.com/")
		.then()
		.header("Content-Type", "text/html; charset=ISO-8859-1")
		.and()
		.header("Content-Encoding", "gzip")
		.header("Server", "gws")
		.log().all();
	}
	
	
	@Test()
	void captureHeaders() {
		
		Response res = given()
		
		.when()
		.get("https://www.google.com/");
		
		String header_Value = res.getHeader("Content-Type");
		System.out.println(header_Value);
		
		
		Headers headers_Values = res.getHeaders();
		
		for(Header hd : headers_Values) {
			
			System.out.println(hd.getName()+"------>"+hd.getValue());
		}
		
	}

}
