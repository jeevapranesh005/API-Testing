package ApiTesting1;

import static org.hamcrest.Matchers.containsString;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Health_check {
	
	@Test(priority=1)
	public void HealthCheck() {
		
		
		
		Response res = RestAssured
						.given()
						.when()
							.get("https://lms-server-3-wedg.onrender.com/");
		
					res.then()
						.statusCode(200)
						.body(containsString("API Running"));;
						
							
				System.out.println("status code "+res.statusCode());
				System.out.println(res.getBody().asString());
				
		
	}
	
	@Test(priority=2)
	public void HealthCheckinvalid() {
		
		
		
		Response res = RestAssured
						.given()
						.when()
							.get("https://lms-server-3-wedg.onrender.com/hospital");
		
//					res.then()
////						.statusCode(200)
////						.body(containsString("API Running"));;
//						
							
				System.out.println("status code "+res.statusCode());
				System.out.println(res.getBody().asString());
				
		
	}
	

}
