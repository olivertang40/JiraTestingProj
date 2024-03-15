package API;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class LoginAPI {

    public LoginAPI() {
        RestAssured.baseURI = "http://localhost:8080";
    }

//    @Test
    public Response testUserLogin() {
        String requestBody = "{ \"username\": \"admin\", \"password\": \"123456\" }";
        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post("/rest/auth/1/session");

        // Check if the response has content
        if (response.getBody().asString() != null && !response.getBody().asString().isEmpty()) {
            response.then()
                    .log().body()
                    .statusCode(200);
        } else {
            System.out.println("Response body is empty or null.");
        }
        return response;
    }
    @Test
    public void testUserLogout() {
        Response response = testUserLogin();
//        String sessionId = response.jsonPath().getString("session.value");
//        response = RestAssured.given()
//                .header("Cookie", "JSESSIONID=" + sessionId)
//                .when()
//                .post("/rest/auth/1/session");
//        response.then().statusCode(204);
    }

}
