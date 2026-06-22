package ApiTesting1;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Course_check {

    @Test(priority = 1)
    public void get_all_courses() {

        base_node obj = new base_node();
        String token = obj.getToken();

        Response res = RestAssured
                .given()
                .header("Authorization", "Bearer " + token)
                .when()
                .get("https://lms-server-3-wedg.onrender.com/courses-structure/getAll");

        res.then()
                .statusCode(200);

        System.out.println("Course ID : " +
                res.jsonPath().getString("data[0]._id"));

        System.out.println("Institution : " +
                res.jsonPath().getString("data[0].institution"));

    }
    
    @Test(priority = 2)
    public void get_course_invalid_token() {

        Response res = RestAssured
                .given()
                .header("Authorization", "Bearer abc123")
                .when()
                .get("https://lms-server-3-wedg.onrender.com/courses-structure/getAll");

        res.then()
                .statusCode(401);

        res.prettyPrint();
    }
    
    
    
}