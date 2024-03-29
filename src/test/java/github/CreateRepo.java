package github;

import org.testng.annotations.Test;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;



public class CreateRepo {
	
	@Test
public void test1() throws IOException {
		
		
		byte[] file = Files.readAllBytes(Paths.get("gitdata.json"));
		
		RestAssured.baseURI = "https://api.github.com/user/repos";
		
		RequestSpecification  request = RestAssured.given();
		
		Response response = request.auth().oauth2(" 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")
									.contentType(ContentType.JSON)
									.accept(ContentType.JSON)
									.body(file)
									.post();
		
		System.out.println("The response is " + response.body().asString());
		System.out.println("The status code is " + response.statusCode());
	}


}
