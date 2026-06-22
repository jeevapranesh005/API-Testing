package ApiTesting1;

import org.testng.annotations.Test; 

import io.restassured.RestAssured;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;

public class Get_all_notes {
	
	@Test(priority=1)
	public void Get_Data_withoutQuery() {
		base_node obj = new base_node();
		String token = obj.getToken();
		System.out.println(token);
		
		
		Response res = RestAssured
				             .given()
				             .header("Authorization","Bearer "+token)
				             .when()
				             		.get("https://lms-server-3-wedg.onrender.com/getAll/notes");
		
				res.then()
					.statusCode(200)
				 	.contentType("application/json")
				 	.body("success", equalTo(true))
				 	.body("data", notNullValue());
					
	}
	
	
	@Test(priority=2)
	public void Get_Data_valid2() {
		base_node obj = new base_node();
		String token = obj.getToken();
		System.out.println(token);
		
		
		Response res = RestAssured
				             .given()
				             .header("Authorization","Bearer "+token)
				             .queryParam("page", 1)
				             .queryParam("limit", 50)
				             .queryParam("search", "API")
				             .queryParam("tags","['qa','demo']")
				             .queryParam("isPinned", false)
				             .queryParam("sortBy","lastEdited")
				             .queryParam("sortOrder","asc")
				             .when()
				             		.get("https://lms-server-3-wedg.onrender.com/getAll/notes");
		
				res.then()
					.statusCode(200)
				  	.contentType("application/json")
				   .body("success", equalTo(true))
				   .body("pagination.currentPage", equalTo(1));
					
	}
	
	@Test(priority=2)
	public void Get_Data_valid3() {
		base_node obj = new base_node();
		String token = obj.getToken();
		System.out.println(token);
		
		
		Response res = RestAssured
				             .given()
				             .header("Authorization","Bearer "+token)
				             .queryParam("page", 1)
				             .queryParam("limit", 50)
				             .queryParam("search", "API")
				             .queryParam("tags","['qa','demo']")
				             .queryParam("isPinned", false)
				             .queryParam("sortBy","lastEdited")
				             .queryParam("sortOrder","desc")
				             .when()
				             		.get("https://lms-server-3-wedg.onrender.com/getAll/notes");
		
				res.then()
					.statusCode(200)
				  	.contentType("application/json")
				   .body("success", equalTo(true))
				   .body("pagination.currentPage", equalTo(1));
					
	}
	
	@Test(priority=3)
	public void Get_Data_valid4() {
		base_node obj = new base_node();
		String token = obj.getToken();
		System.out.println(token);
		
		
		Response res = RestAssured
				             .given()
				             .header("Authorization","Bearer "+token)
				             .queryParam("page", 1)
				             .queryParam("limit", 50)
				             .queryParam("search", "API")
				             .queryParam("tags","qa")
				             .queryParam("isPinned", false)
				             .queryParam("sortBy","title")
				             .queryParam("sortOrder","asc")
				             .when()
				             		.get("https://lms-server-3-wedg.onrender.com/getAll/notes");
		
				res.then()
					.statusCode(200);	
				
					
	}
	
	@Test(priority=4)
	public void Get_Data_valid5() {
		base_node obj = new base_node();
		String token = obj.getToken();
		System.out.println(token);
		
		
		Response res = RestAssured
				             .given()
				             .header("Authorization","Bearer "+token)
				             .queryParam("page", 1)
				             .queryParam("limit", 50)
				             .queryParam("search", "API")
				             .queryParam("tags","qa")
				             .queryParam("isPinned", true)
				             .queryParam("sortBy","title")
				             .queryParam("sortOrder","desc")
				             .when()
				             		.get("https://lms-server-3-wedg.onrender.com/getAll/notes");
		
				res.then()
					.statusCode(200);	
				
					
	}
	
	@Test(priority=5)
	public void Get_Data_InvalidPage() {

	    base_node obj = new base_node();
	    String token = obj.getToken();

	    Response res = RestAssured
	            .given()
	            .header("Authorization", "Bearer " + token)
	            .queryParam("page", -1)
	            .when()
	            .get("https://lms-server-3-wedg.onrender.com/getAll/notes");

	    res.then()
	            .statusCode(400);

	    res.prettyPrint();
	}
	
	@Test(priority=6)
	public void Get_Data_InvalidLimit() {

	    base_node obj = new base_node();
	    String token = obj.getToken();

	    Response res = RestAssured
	            .given()
	            .header("Authorization", "Bearer " + token)
	            .queryParam("limit", -10)
	            .when()
	            .get("https://lms-server-3-wedg.onrender.com/getAll/notes");

	    res.then()
	            .statusCode(400);

	    res.prettyPrint();
	}
	
	@Test(priority=7)
	public void Get_Data_InvalidSortBy() {

	    base_node obj = new base_node();
	    String token = obj.getToken();

	    Response res = RestAssured
	            .given()
	            .header("Authorization", "Bearer " + token)
	            .queryParam("sortBy", "xyz")
	            .when()
	            .get("https://lms-server-3-wedg.onrender.com/getAll/notes");

	    res.then()
	            .statusCode(400);

	    res.prettyPrint();
	}
	
	@Test(priority=8)
	public void Get_Data_InvalidSortOrder() {

	    base_node obj = new base_node();
	    String token = obj.getToken();

	    Response res = RestAssured
	            .given()
	            .header("Authorization", "Bearer " + token)
	            .queryParam("sortOrder", "wrong")
	            .when()
	            .get("https://lms-server-3-wedg.onrender.com/getAll/notes");

	    res.then()
	            .statusCode(400);

	    res.prettyPrint();
	}

}
