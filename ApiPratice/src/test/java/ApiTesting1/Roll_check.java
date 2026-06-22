package ApiTesting1;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Roll_check {
	
	@Test(priority=1)
	public void all_roles() {
		
		base_node obj = new base_node();
		String token = obj.getToken();
		System.out.println(token);
		
		
		
		Response res = RestAssured
							.given()
							.header("Authorization", "Bearer " + token)
							.when()
								.get("https://lms-server-3-wedg.onrender.com/"+"roles/getAll");
			
		System.out.println("token :"+token);
				res.then()
						.statusCode(200);
				
				res.prettyPrint();

	}
	
}
