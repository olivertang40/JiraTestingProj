package API;

import Entity.RequestVo;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.request;

public class GroupAPI extends BaseAPI {

    public GroupAPI() {
        requestSpec.basePath("/rest/api/2/group");
    }

    public Response createGroup(String groupName) {
//        RequestVo requestVo = RequestVo.builder()
//                .id("https://docs.atlassian.com/jira/REST/schema/add-group#")
//                .title("Add Group")
//                .type("object")
//                .additionalProperties(false)
//                .name(groupName).build();

        String requestBody = "{ \"id\": \"https://docs.atlassian.com/jira/REST/schema/add-group#\", "
                + "\"title\": \"Add Group\", "
                + "\"type\": \"object\", "
                + "\"additionalProperties\": false, "
                + "\"name\": \"test\" }";

        Response response = given(requestSpec)
                .auth().preemptive().basic("admin", "12345")
                .body(requestBody)
                .post();


        response.then()
                .spec(responseSpec)
//                .log().all()
                .statusCode(201);
        return response;
    }

    public Response getGroup() {
//        RestAssured.baseURI = "http://localhost:8080";
        Response response = given(requestSpec)
//                .contentType(ContentType.JSON)
                .auth().preemptive().basic("admin", "12345")
                .queryParam("groupname", "dev")
                .when()
                .post("/member");

        response.then()
                .spec(responseSpec)
//                .log().body()
                .statusCode(200);

        return response;
    }

    public Response addUserToGroup(){
        String requestBody = "{ \"name\": \"test\" }";
        Response response = RestAssured.given(requestSpec)
                .auth().preemptive().basic("admin", "12345")
                .queryParam("groupname","test")
                .body(requestBody)
                .post("/user");

        response.then()
                .spec(responseSpec)
                .log().all()
                .statusCode(201);

        return response;
    }

    public Response getUsersByRole() {
        int roleId = 10101;
        requestSpec.basePath("/rest/api/2/project");
        Response response = given(requestSpec)
                .auth().preemptive().basic("admin", "12345")
                .pathParams("roleId", roleId)
                .when()
                .get("/10000/role/{roleId}");

        response.then()
                .spec(responseSpec)
//                .log().body()
                .statusCode(200);

        return response;
    }
}
