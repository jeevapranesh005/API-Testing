package apiTesting;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetTAPITest {
	@Test
	public void getuserTest() {
		Response response =RestAssured.given().when().get("https://jsonplaceholder.typicode.com/users/3");
		System.out.println("status Code : "+response.getStatusCode());
		response.prettyPrint();
		Assert.assertEquals(response.getStatusCode(), 200);
		System.out.println("respinse is correct");
		
		String name= response.jsonPath().getString("name");
		System.out.println("name is : "+name);
		
		
	}

}
