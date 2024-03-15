package StepDefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class AddUserToProjectAPI {
    private final String projectId = "10003"; // Replace with the actual project ID
    private Response response;

    @When("I add a user to the current project")
    public void i_add_a_user_to_the_current_project() {
        String requestBody = "{ \"user\": [\"charlie\"] }";
        response = RestAssured.given()
                .auth().preemptive().basic("admin", "12345")
                .contentType(ContentType.JSON)
                .body(requestBody)
                .post("http://localhost:8080/rest/api/2/project/" + projectId + "/role/10002");
    }

    @Then("the user should be added to the project successfully")
    public void the_user_should_be_added_to_the_project_successfully() {
        response.then().log().body().statusCode(200);
    }

}
