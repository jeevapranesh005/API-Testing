package apiTesting;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class POST {
	
	@Test
	public void f() {
		
		String requestBody = """
				{
				    "name":"John",
				    "job":"QA"
				}
				""";
			
			
			Response res= RestAssured.given().header("Content-Type","application/json").body(requestBody)
					.when().post("http://localhost:3000/traninee");
			
			System.out.println("Status code "+res.statusCode());
		
	}
	
	
	
	

}
