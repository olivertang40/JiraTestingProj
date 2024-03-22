package StepDefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONObject;

public class PermissionSchemeAPI {

    private Response response;
    @When("I create a permission scheme")
    public void iCreateAPermissionScheme() {
        //build up a json request body
        JSONObject requestBody = new JSONObject();
        requestBody.put("name", "new permission scheme");
        requestBody.put("description", "a team lead user can manage sprints and assign issues, a developer can resolve issue, and a QA can close issue");

        JSONArray permissionsArray = new JSONArray();

        JSONObject permission1 = new JSONObject();
        JSONObject holder1 = new JSONObject();
        holder1.put("type", "user");
        holder1.put("parameter", "admin");
        permission1.put("holder", holder1);
        permission1.put("permission", "MANAGE_SPRINTS_PERMISSION");
        permissionsArray.put(permission1);

        JSONObject permission2 = new JSONObject();
        JSONObject holder2 = new JSONObject();
        holder2.put("type", "user");
        holder2.put("parameter", "admin");
        permission2.put("holder", holder2);
        permission2.put("permission", "ASSIGN_ISSUES");
        permissionsArray.put(permission2);

        JSONObject permission3 = new JSONObject();
        JSONObject holder3 = new JSONObject();
        holder3.put("type", "user");
        holder3.put("parameter", "user1");
        permission3.put("holder", holder3);
        permission3.put("permission", "RESOLVE_ISSUES");
        permissionsArray.put(permission3);

        JSONObject permission4 = new JSONObject();
        JSONObject holder4 = new JSONObject();
        holder4.put("type", "user");
        holder4.put("parameter", "user2");
        permission4.put("holder", holder4);
        permission4.put("permission", "CLOSE_ISSUES");
        permissionsArray.put(permission4);

        requestBody.put("permissions", permissionsArray);

        response = RestAssured.given()
                .auth().preemptive().basic("admin", "12345")
                .contentType(ContentType.JSON)
                .body(requestBody.toString())
                .post("http://localhost:8080/rest/api/2/permissionscheme");
    }

    @Then("permission scheme should be created successfully")
    public void permissionSchemeShouldBeCreatedSuccessfully() {
        response.then().statusCode(201);
    }
}
