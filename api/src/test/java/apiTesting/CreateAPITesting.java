package apiTesting;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class CreateAPITesting {
  @Test
  public void f() {
	  Map<String,Object>payload=new HashMap<>();
	  payload.put("title","My first post");
	  payload.put("body", "learn rest assured");
	  payload.put("userID", 1);
	  
	  Response response =RestAssured.given().contentType(ContentType.JSON).body(payload).when()
			  .post("https://jsonplaceholder.typicode.com/posts");
	  
	  System.out.println("statuse code: "+response.getStatusCode());
	  Assert.assertEquals(response.getStatusCode(), 201);
	  response.prettyPrint();
	  
	  Assert.assertEquals(response.jsonPath().getString("title"),"My first post");
	
  }
}
