package restAPI;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetRequestWithParameters {
	
@Test	
public void test1() {
		
		RestAssured.baseURI = "http://localhost:3000/employees";
		RequestSpecification  request = RestAssured.given();
		Response response = request.get("/1");
		
        System.out.println("The Response body is " + response.body().asString());
		
		AssertJUnit.assertEquals(response.getStatusCode(), 200);
		String ResponseBody =response.body().asString();
		AssertJUnit.assertTrue( ResponseBody.contains("Pankaj") );
		
		JsonPath json= response.jsonPath();
		String actName = json.get("name");
		String expName = "Pankaj";
		AssertJUnit.assertEquals(actName, expName);

		

		}
    }