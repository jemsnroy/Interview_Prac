package Session5;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
public class ResponseBobyInXMLFormatTest {
	
	
	@Test(priority = 1)
	void testA() {
		
		given()
		
		.queryParam("page", 1)
		
		
		.when()
		.get("http://restapi.adequateshop.com/api/Traveler")
		
		
		.then()
		.statusCode(200)
		.header("Content-Type", "application/xml; charset=utf-8")
		.body("TravelerinformationResponse.page", equalTo("1"))
		.body("TravelerinformationResponse.totalrecord", equalTo("6447"))
		.body("TravelerinformationResponse.travelers.Travelerinformation[0].name", equalTo("Developer"))
		.log().all();
		
		
	}
	
	@Test(priority = 2)
	void testB() {
		
Response res = given()
		
		.queryParam("page", 1)
		
		
		.when()
		.get("http://restapi.adequateshop.com/api/Traveler");

Assert.assertEquals(res.statusCode(), 200);
Assert.assertEquals(res.header("Content-Type"), "application/xml; charset=utf-8");
Assert.assertEquals(res.xmlPath().get("TravelerinformationResponse.page"),"1");
Assert.assertEquals(res.xmlPath().get("TravelerinformationResponse.travelers.Travelerinformation[0].name"),"Developer");		
	}
	
	@Test(priority = 3)
	void testC() {
		
Response res = given()
		
		.queryParam("page", 1)
		
		
		.when()
		.get("http://restapi.adequateshop.com/api/Traveler");

XmlPath xo = new XmlPath(res.asString());
List<String> name_Value=  xo.getList("TravelerinformationResponse.travelers.Travelerinformation.name");
System.out.println(name_Value.size());
	boolean flag = false;
for(String name:name_Value) {
	
	System.out.println(name);
	if(name.equals("Developer")) {
		
		flag = true;
		break;
	}
	Assert.assertEquals(flag, true);
}

	
	
	}

}
