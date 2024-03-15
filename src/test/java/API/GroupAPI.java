package API;

import Entity.RequestVo;
import api.BaseAPI;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GroupAPI extends BaseAPI {

    public GroupAPI() {
        requestSpec.basePath("/rest/auth/2/group");
//        RestAssured.baseURI = "http://localhost:8080";
    }

    @Test
    public Response createGroup(String groupName) {
        RestAssured.baseURI = "http://localhost:8080";
        RequestVo requestVo = RequestVo.builder()
                .id("https://docs.atlassian.com/jira/REST/schema/add-group#")
                .title("Add Group")
                .type("object")
                .additionalProperties(false)
                .name(groupName).build();

        Response response = given()
                .contentType(ContentType.JSON)
                .auth().preemptive().basic("admin", "12345")
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
                .queryParam("groupname", "dev")
                .when()
                .post("/rest/auth/2/group/member");

        response.then()
                .log().body()
                .statusCode(200);
        return response;
    }
}
