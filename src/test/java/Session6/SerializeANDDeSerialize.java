package Session6;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class SerializeANDDeSerialize {
	
	
	
	
	@Test(priority=1)
	void convertJAVAObjecttoJSONObject() throws JsonProcessingException {
		
		pojoRequest pojoObject = new pojoRequest();	
		
		pojoObject.setName("Kishan");
		pojoObject.setPhone("12345");
		
		String coursesArray[] = {"Civil","Engineer"};
		pojoObject.setCourses(coursesArray);
		
		
		ObjectMapper objMap = new ObjectMapper();
		String jsonValue = objMap.writerWithDefaultPrettyPrinter().writeValueAsString(pojoObject);
		System.out.println(jsonValue);

	}
	
	@Test(priority=2)
	void convertJSONObjecttoJAVAObject() throws JsonMappingException, JsonProcessingException {
		
		String jsonObject = "{\r\n"
				+ "  \"name\" : \"Kishan\",\r\n"
				+ "  \"phone\" : \"12345\",\r\n"
				+ "  \"courses\" : [ \"Civil\", \"Engineer\" ]\r\n"
				+ "}"; 
		
		ObjectMapper objMap = new ObjectMapper();
		pojoRequest javaObj = objMap.readValue(jsonObject, pojoRequest.class);
	System.out.println("Name: "+javaObj.getName());
	System.out.println("Phone: "+javaObj.getPhone());
	System.out.println("Course 1: "+javaObj.getCourses()[0]);
	System.out.println("Course 2: "+javaObj.getCourses()[1]);
	}

}
