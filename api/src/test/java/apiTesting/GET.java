package apiTesting;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
public class GET {
	
	@Test
	public void f() {
		
		Response res = RestAssured.given().when().get("http://localhost:3000/traninee/3");
		
		res.prettyPeek();
	}

}
