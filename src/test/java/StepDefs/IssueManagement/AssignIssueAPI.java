package StepDefs.IssueManagement;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class AssignIssueAPI {
    private final String issueId = "10108"; // Replace with the actual issue ID
    private final String assignee = "charlie"; // Replace with the actual assignee
    private Response response;

    @When("I assign the issue to the assignee")
    public void i_assign_the_issue_to_the_assignee() {
        String requestBody = "{ \"name\": \"" + assignee + "\" }";
        response = RestAssured.given()
                .auth().preemptive().basic("admin", "12345")
                .contentType(ContentType.JSON)
                .body(requestBody)
                .put("http://localhost:8080/rest/api/2/issue/" + issueId + "/assignee");
    }

    @Then("the issue should be assigned to the assignee successfully")
    public void the_issue_should_be_assigned_to_the_assignee_successfully() {
        response.then().log().body().statusCode(204);
    }
}
