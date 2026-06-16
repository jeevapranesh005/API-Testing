package apiTesting;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class PUT {
	
	@Test
	public void f() {
		String put ="""
				{
					"name":"bheem",
					"age":21
					}
				""";
		
		Response res= RestAssured
				.given()
				.header("Content-Type","application/json")
				.body(put)
				.when()
				.put("http://localhost:3000/traninee/3");
				
				
				res.then().statusCode(200);
		
		System.out.println("status "+res.statusCode());
		
		
		
	}

}
