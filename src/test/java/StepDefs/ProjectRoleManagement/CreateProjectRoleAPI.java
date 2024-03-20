package StepDefs.ProjectRoleManagement;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;

public class CreateProjectRoleAPI {
    private Response response;

    @When("I create an project role with the following details")
    public void i_create_an_project_role_with_the_following_details() {
        // Create a JSON object with the role details
        JSONObject roleDetails = new JSONObject();
        roleDetails.put("name", "MyRoleTest");
        roleDetails.put("description", "role description");

        // Send a POST request to create the role
        response = RestAssured.given()
                .auth().preemptive().basic("admin", "12345") // Use basic authentication
                .contentType(ContentType.JSON)
                .body(roleDetails.toString())
                .post("http://localhost:8080/rest/api/2/role"); // Replace with your JIRA instance URL
    }

    @Then("the role should be created successfully with API")
    public void the_role_should_be_created_successfully_with_API() {
        // Check that the response status code is 201 (Created)
        response.then().statusCode(200);
    }
}
