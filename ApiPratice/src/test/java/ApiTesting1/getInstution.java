package ApiTesting1;

import static org.hamcrest.Matchers.hasItem;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class getInstution {
	
	@Test
	public void institutions() {
		
		Response res = RestAssured
						.given()
						.when()
						.get("https://lms-server-3-wedg.onrender.com/getAll/institution");
			
				res.then()
					.statusCode(200)
					 .body("message.key", hasItem("success"));
				
				res.prettyPrint();
	}
	
	@Test
	public void Invalid_institutions() {
		
		Response res = RestAssured
						.given()
						.when()
						.get("https://lms-server-3-wedg.onrender.com/getAll/institutions");
		
		
		
			
				res.then()
					.statusCode(404);
					 
	}

}
