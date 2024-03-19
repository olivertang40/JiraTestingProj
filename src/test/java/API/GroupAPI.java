package API;

import Entity.RequestVo;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

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
                + "\"name\": \"" + groupName + "\" }";

        Response response = given(requestSpec)
                .auth().preemptive().basic("admin", "localhost8080")
                .body(requestBody)
                .post();


        response.then()
                .spec(responseSpec)
//                .log().all()
                .statusCode(201);
        return response;
    }

    public Response getGroup() {
        Response response = given(requestSpec)
//                .contentType(ContentType.JSON)
                .auth().preemptive().basic("admin", "localhost8080")
                .queryParam("groupname", "test3")
                .when()
                .post("/member");

        response.then()
                .spec(responseSpec)
//                .log().body()
                .statusCode(200);

        return response;
    }

    public Response addUserToGroup(String username, String groupName){
        String requestBody = "{ \"name\": \"" + username +"\" }";
        Response response = RestAssured.given(requestSpec)
                .auth().preemptive().basic("admin", "localhost8080")
                .queryParam("groupname", groupName)
                .body(requestBody)
                .post("/user");

        response.then()
                .spec(responseSpec)
                .log().all()
                .statusCode(201);

        return response;
    }

    public Response getUsersByRole(int roleId) {
//        int roleId = 10101;
        requestSpec.basePath("/rest/api/2/project");
        Response response = given(requestSpec)
                .auth().preemptive().basic("admin", "localhost8080")
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
