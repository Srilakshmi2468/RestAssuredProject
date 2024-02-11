package restAPIBDD;

import org.testng.annotations.Test;
import java.util.HashMap;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class APIOperationsTest {
	
	String BaseURI = "http://localhost:3000/employees";

	@Test
	public void GetOperation() {
		RestAssured.given().baseUri("http://localhost:3000/employees")
		.when().get().then().log().body().statusCode(200);
		
		}

	
	@Test
	public void GetOperationWithPathParameters() {
		RestAssured.given().baseUri("http://localhost:3000/employees")
		.when().get("/6").then().log().body().statusCode(200)
		.body("name",Matchers.equalTo("Raj"))
		.body("salary",Matchers.equalTo("6000"));
		
		}
	
	@Test
	public void GetOperationWithQueryParameters() {
		RestAssured.given()
	    .queryParam("CUSTOMER_ID","68195")
		.queryParam("PASSWORD", "1234!")
		.queryParam("Account_No", "1")
		.baseUri("https://demo.guru99.com/V4/sinkministatement.php")
		.when().get().then().log().body().statusCode(200);
		
		}
	
	@Test
	public void PostOperationWithHashMap() {
		
		
		HashMap<String,String> obj = new HashMap<String,String>();
		
		obj.put("name", "John");
		obj.put("salary", "9000");
		obj.put("id", "10");
		
		RestAssured.given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(obj)
	    .baseUri(BaseURI)
		.when().post()
		.then().log().body().statusCode(201);
		
		}
	
	@Test
	public void PutOperationWithHashMap() {
		
		
		HashMap<String,String> obj = new HashMap<String,String>();
		
		obj.put("name", "John");
		obj.put("salary", "10000");
		obj.put("id", "10");
		
		RestAssured.given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(obj)
	    .baseUri(BaseURI)
		.when().put("/10")
		.then().log().body().statusCode(200);
		
		}
	
	@Test
	public void  DeleteOperationWithHashMap() {
			
		
		RestAssured.given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		
		.baseUri(BaseURI)
		.when().delete("/10")
		.then().log().body().statusCode(200);
		
		}
	
	

	
}
