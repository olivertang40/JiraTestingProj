package API;

import Entity.RequestVo;
import Entity.User;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class LoginAPI extends BaseAPI {

    public LoginAPI() {
        requestSpec.basePath("/rest/auth/1/session");
        RestAssured.baseURI = "http://localhost:8080";
    }

    @Test
    public Response userLogin(User user) {
//        String requestBody = "{ \"username\": \"admin\", \"password\": \"12345\" }";
//        User admin = User.builder().username("admin").password("12345").build();
        Response response = RestAssured.given(requestSpec)
//                .auth().preemptive().basic("admin","12345")
                .body(user)
                .when()
                .post();
        return response;

    }

    @Test
    public Response createGroup() {
        RequestVo requestVo = RequestVo.builder()
                .id("https://docs.atlassian.com/jira/REST/schema/add-group#")
                .title("Add Group")
                .type("object")
                .additionalProperties(false)
                .name("test").build();

        Response response = given(requestSpec)
//                .contentType(ContentType.JSON)
//                .auth().basic("admin","12345")
                .body(requestVo.toString())
                .when()
                .post("/rest/api/2/group");
        response.then()
                .log().body()
                .statusCode(201);
        return response;
    }

    @Test
    public Response getGroup() {
        RestAssured.baseURI = "http://localhost:8080";
        Response response = given()
                .contentType(ContentType.JSON)
                .auth().basic("admin", "12345")
                .pathParam("groupname", "dev")
                .when()
                .post("/rest/auth/2/group/member");

        response.then()
                .log().body()
                .statusCode(200);
        return response;
    }
}
