package StepDefs.IssueManagement;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;

public class CreateIssueAPI {
    private final String projectId = "10003"; // Replace with the actual project ID
    private Response response;

    @When("I create an issue with the following details")
    public void i_create_an_issue_with_the_following_details() {
        // Create a JSON object with the issue details
        JSONObject issueDetails = new JSONObject();
        issueDetails.put("fields", new JSONObject()
                .put("project", new JSONObject().put("id", "10003"))
                .put("summary", "something wrong")
                .put("issuetype", new JSONObject().put("id", "10001"))
                .put("assignee", new JSONObject().put("name", "admin"))
                .put("customfield_10102", "JIRA-99"));

        // Send a POST request to create the issue
        response = RestAssured.given()
                .auth().preemptive().basic("admin", "12345") // Use basic authentication
                .contentType(ContentType.JSON)
                .body(issueDetails.toString())
                .post("http://localhost:8080/rest/api/2/issue"); // Replace with your JIRA instance URL
    }

    @Then("the issue should be created successfully with API")
    public void the_issue_should_be_created_successfully_with_API() {
        // Check that the response status code is 201 (Created)
        response.then().statusCode(201);
    }
}