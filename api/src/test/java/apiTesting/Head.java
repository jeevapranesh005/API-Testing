package apiTesting;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Head {
	
	@Test
	public void f() {
			
			Response res = RestAssured.given().when().head("http://localhost:3000/traninee/9");
			
			res.prettyPeek();
		}
}
