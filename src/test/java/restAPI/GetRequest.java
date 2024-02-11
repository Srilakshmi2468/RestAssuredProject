package restAPI;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetRequest {
	
	@Test
	public void test1() {
		
		RestAssured.baseURI = "http://localhost:3000/employees";
		RequestSpecification  request = RestAssured.given();
		Response response = request.get();
		
		String responseBody = response.body().asString();
		
		System.out.println(responseBody);
		System.out.println("Response code is " + response.statusCode());
		AssertJUnit.assertEquals(response.statusCode(), 200);
		//Print all the  names in the response
		
		JsonPath json= response.jsonPath();
		List <String> allNames= json.get("name");
		for (String name:allNames) {
			System.out.println(name);
		}
	
      System.out.println("second Value" + "  "+ allNames.get(1));
      System.out.println("Third Value"  + "   "+ allNames.get(2));
	}

}
