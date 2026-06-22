package ApiTesting1;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class base_node {
	
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
	
	public String getToken() {
		Login();
		return token;
	}

}
