package github;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DeleteRepo {
	
	@Test
	public void test1() {
RestAssured.baseURI = "https://github.com/Srilakshmi2468/RestAssuredRepo";
		
		RequestSpecification  request = RestAssured.given();
		
		Response response = request.auth().oauth2("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")
							.delete();
		
		System.out.println("The Response body is " + response.body().asString());

		
	}

}
