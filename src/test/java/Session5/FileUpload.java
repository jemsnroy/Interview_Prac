package Session5;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.File;

import org.testng.annotations.Test;


public class FileUpload {

	
	
	@Test(priority=1)
	void uploadSingleFile() {
		
		File f = new File("D:\\JSONFakeData\\Test1.txt");
		
		given()
		.multiPart("file",f)
		.contentType("multipart/form-data")
		
		
		.when()
		.post("http://localhost:8080/uploadFile")
		.then()
		.statusCode(200)
		.header("Content-Type", "application/json")
		.body("fileName", equalTo("Test1.txt"))
		.log().all();
		
	}
	
	@Test(priority=2)
	void uploadMultipleFiles() {
		
		File f1 = new File("D:\\JSONFakeData\\Test1.txt");
		File f2 = new File("D:\\JSONFakeData\\Test2.txt");
		
		//File file[] = {f1, f2};
		
		given()
		.multiPart("files",f1)
		.multiPart("files",f2)
		//.multiPart("files",file)
		.contentType("multipart/form-data")
		
		
		.when()
		.post("http://localhost:8080/uploadMultipleFiles")
		.then()
		.statusCode(200)
		.header("Content-Type", "application/json")
		.body("[0].fileName", equalTo("Test1.txt"))
		.body("[1].fileName", equalTo("Test2.txt"))
		.log().all();
		
	}
	
	@Test(priority=3)
	void downloadFile() {
		
	
		
		given()
		
		.when()
		.get("http://localhost:8080/downloadFile/Test1.txt")
		.then()
		.statusCode(200)
		.log().all();
		
	}
	
	
}
