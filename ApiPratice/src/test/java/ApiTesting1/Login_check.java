package ApiTesting1;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Login_check {
	
	String token="";
	
	@Test
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
								.post("https://lms-server-3-wedg.onrender.com/"+"user/login");
		
		
		res.then()
				.statusCode(201);
		

		
		token=res.jsonPath().getString("token");
		
	}
	
	@Test
	public void LoginWithInvalidEmail() {
		
		String login = """
			{
			
			"email":"sam@gmail",
			"password":"123"
			}

			""";
		
		Response res = RestAssured
						.given()
							.contentType("application/json")
							.body(login)
							.when()	
								.post("https://lms-server-3-wedg.onrender.com/"+"user/login");
		
		
		res.then()
				.statusCode(400);
		

		
		token=res.jsonPath().getString("token");
		
	}
	
	
	@Test
	public void LoginWithInvalidPassword() {
		
		String login = """
			{
			
			"email":"sam@gmail.com",
			"password":"123789"
			}

			""";
		
		Response res = RestAssured
						.given()
							.contentType("application/json")
							.body(login)
							.when()	
								.post("https://lms-server-3-wedg.onrender.com/"+"user/login");
		
		
		res.then()
				.statusCode(400);
		
		
	}
	

	@Test
	public void LoginWithInvalidEmpty() {
		
		String login = """
			{
			
			
			}

			""";
		
		Response res = RestAssured
						.given()
							.contentType("application/json")
							.body(login)
							.when()	
								.post("https://lms-server-3-wedg.onrender.com/"+"user/login");
		
		
		res.then()
				.statusCode(400);
		
		
	}
}
