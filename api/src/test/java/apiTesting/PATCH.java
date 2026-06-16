package apiTesting;

import org.testng.annotations.Test;
import io.restassured.response.Response;
import io.restassured.RestAssured;

public class PATCH {
	
	@Test
	public void f() {
		
		String patch="""
				{
					"name":"raajuu"
				}
				""";
		
		Response res = RestAssured.given().header("Content-type","application/json")
				.body(patch).when().patch("http://localhost:3000/traninee/3");
		
		res.then().statusCode(200);
		
		System.out.println("name : "+res.jsonPath().getString("name"));
		
	}

}
