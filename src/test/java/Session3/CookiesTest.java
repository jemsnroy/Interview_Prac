package Session3;

import static io.restassured.RestAssured.given;

import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class CookiesTest {

	//@Test
	void getUser() {

		given()

				.when().get("https://www.google.com/")

				.then()

				.log().all();

	}

	@Test
	void verifyCookie() {

		Response res = given()

				.when().get("https://www.google.com/"); //if we don't put semi colon here and we directly start .then. it will not capture the value of cookie.

		//Capture the value of cookie.
		String cookie_Value = res.getCookie("AEC");
		System.out.println("value of cookie is----->" + cookie_Value);

		//Capture the values of all cookies.
		
		Map<String, String> cookies_value = res.getCookies();
		System.out.println(cookies_value.keySet());
		
		for(String k : cookies_value.keySet()) {
			
			String cookie_value = res.getCookie(k);
			System.out.println(k+"------>"+cookie_value);
			
		}
		
	}
}
