package apiTesting;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class OPTIONS {
		
	@Test
	public void f() {
			
			Response res = RestAssured.given().when().options("http://localhost:3000/traninee");
			
			System.out.println("res options");
			System.out.println("staus "+res.statusCode());
			res.prettyPeek();
			
		}


}
