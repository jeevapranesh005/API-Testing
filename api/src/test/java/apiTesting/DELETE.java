package apiTesting;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DELETE {
	
	@Test
	public void f() {
			
			Response res = RestAssured.given().when().get("http://localhost:3000/traninee/4");
			System.out.println("=============");
			res.prettyPrint();
			System.out.println("=============");
			Response res1 = RestAssured.given().when().delete("http://localhost:3000/traninee/4");
			
			System.out.println("=============");
			res1.prettyPrint();
			System.out.println("=============");
		}


}
