package ApiTesting1;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Create_note {
	
	@Test(priority=1)
	public void Createnote() {
		base_node obj = new base_node();
	    String token = obj.getToken();
		
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
			
				String node=res.jsonPath().getString("data._id");
			
				
	}
	
	@Test(priority=2)
	public void CreateNote_WithoutToken() {
		
		base_node obj = new base_node();
	    String token = obj.getToken();

	    Map<String, Object> payload = new HashMap<>();
	    payload.put("title", "Prassna");
	    payload.put("content", "he is a boy");

	    Response res = RestAssured
	            .given()
	            .header("Content-Type", "application/json")
	            .body(payload)
	            .when()
	            .post("https://lms-server-3-wedg.onrender.com/create/notes");

	    res.then()
	            .statusCode(401);

	    res.prettyPrint();
	}
	
	
	@Test(priority=3)
	public void CreateNote_InvalidMethod() {
		
		base_node obj = new base_node();
	    String token = obj.getToken();

	    Response res = RestAssured
	            .given()
	            .header("Authorization", "Bearer " + token)
	            .when()
	            .get("https://lms-server-3-wedg.onrender.com/create/notes");

	    res.then()
	            .statusCode(404);

	    res.prettyPrint();
	}

}
