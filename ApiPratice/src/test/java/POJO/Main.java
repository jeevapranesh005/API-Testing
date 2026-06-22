package POJO;

import static io.restassured.RestAssured.given;

public class Main {

    public static void main(String[] args) {

        User user = new User();
        user.setName("John");
        user.setJob("QA");

        given()
            .contentType("application/json")
            .body(user)
        .when()
            .post("https://reqres.in/api/users")
        .then()
            .statusCode(201);

        System.out.println("User created successfully");
    }
}