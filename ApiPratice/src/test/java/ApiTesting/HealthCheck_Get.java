package ApiTesting;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class HealthCheck_Get {
	String baseurl="https://lms-server-3-wedg.onrender.com/";
	String token="";
	String node="";
	
	//1.
	@Test(priority=1)
	public void HealthCheck() {
		
		
		
		Response res = RestAssured
						.given()
						.when()
							.get(baseurl);
		
					res.then()
						.statusCode(200)
						.body(containsString("API Running"));;
						
							
				System.out.println("status code "+res.statusCode());
				System.out.println(res.getBody().asString());
				
		
	}
	
	//2.
	@BeforeClass
	public void Login() {
		
		String login = """
			{
			
			"email":"sam@gmail.com",
			"password":"123"
			}

			""";
		
		Response res = RestAssured
						.given()
							.contentType("application/json")
							.body(login)
							.when()	
								.post(baseurl+"user/login");
		
		
		res.then()
				.statusCode(201);
		

		
		token=res.jsonPath().getString("token");
		
	}
	
	//3.
	@Test(priority=2)
	public void institutions() {
		
		Response res = RestAssured
						.given()
						.when()
						.get(baseurl+"getAll/institution");
		
		
		
			
				res.then()
					.statusCode(200)
					 .body("message.key", hasItem("success"));
				
				res.prettyPrint();
	}
	
	
	//4.
	@Test(priority=3)
	public void all_roles() {
		
		
		Response res = RestAssured
							.given()
							.header("Authorization", "Bearer " + token)
							.when()
								.get(baseurl+"roles/getAll");
			
		System.out.println("token :"+token);
				res.then()
						.statusCode(200);
				
				res.prettyPrint();

	}
	
	
	//5.
	@Test(priority=4)
	public void invalid_all_roles() {
		
		
		Response res = RestAssured
							.given()
							.header("Authorization", "Bearer ")
							.when()
								.get(baseurl+"roles/getAll");
			
		System.out.println("token :"+token);
				res.then()
						.statusCode(401);
				
				res.prettyPrint();

	}
	
	
	//6.
	@Test(priority=5)
	public void Create_note() {
		
		
		Map<String ,Object> payload = new HashMap<>();
		payload.put("title", "Prassna");
		payload.put("content", "he is a boy");
		payload.put("tags", "['tester','developer']");
		payload.put("isPinned", true);
		payload.put("color", "#ffffff");
		
		
		
		
		Response res = RestAssured
							.given()
								.header("Content-Type","application/json")
								.header("Authorization", "Bearer " + token)
								.body(payload)
							.when()
								.post("https://lms-server-3-wedg.onrender.com/create/notes");
				
				res.then()
						.statusCode(201);
				System.out.println(res.statusCode());
			
				node=res.jsonPath().getString("data._id");
			
				
	}
	
	
	//7.
	@Test(priority=6)
	public void Get_all_notes() {
		
		Response res = RestAssured
				             .given()
				             .header("Authorization","Bearer "+token)
				             .queryParam("page", 1)
				             .queryParam("limit", 50)
				             .when()
				             		.get("https://lms-server-3-wedg.onrender.com/getAll/notes");
		
				res.then()
					.statusCode(200);
	}
	
	//8
	
	@Test(priority=7,dependsOnMethods="Create_note")
	public void Get_ID() {
		Response res =RestAssured
							.given()
								.pathParam("id", node)
								.header("Authorization","Bearer "+token)
							.when()
								.get("https://lms-server-3-wedg.onrender.com/getById/notes/{id}");
				res.then()
						.statusCode(200);
				res.prettyPrint();
				
				
	}
	
	
	@Test(priority=8,dependsOnMethods="Create_note")
	public void update() {
		
		Map<String,Object> payload=new HashMap<>();
		payload.put("title", "bheem");
		
		Response res= RestAssured.given()
								.header("Authorization","Bearer "+token)
								.header("Content-Type","application/json")
								.pathParam("id", node)
								.body(payload)
								.when()
								.put("https://lms-server-3-wedg.onrender.com/update/notes/{id}");
					
					res.then()
					.statusCode(200);
					res.prettyPrint();
							
	}
	
	@Test(priority=9,dependsOnMethods="Create_note")
	public void Toggle() {
		
		Response res = RestAssured.given()
								.header("Authorization","Bearer "+token)
								.pathParam("id", node)
								.when()
								.put("https://lms-server-3-wedg.onrender.com/toggle-pin/notes/{id}");
				
		
					res.then()
					 	.statusCode(200);
		
	}
	
	@Test(priority=10,dependsOnMethods="Create_note")
	public void Delete() {
		Response res = RestAssured.given()
								.header("Authorization","Bearer "+token)
								.pathParam("id", node)
								.when()
								.delete("https://lms-server-3-wedg.onrender.com/delete/notes/ById/{id}");
		
		res.then().statusCode(200);
	}


}
