package ProjectManagement;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class TestCreateScrumProject {
    String projectId;
    private Response response;

    @Given("I am logged in as an admin user")
    public void loggedInAsAdminUser() {
        RestAssured.authentication = RestAssured.basic("zeenwang7", "970227");
    }

    @When("I create a Scrum project with given details")
    public void createScrumProject() {
        String requestBody = "{ \"key\": \"SOF\", \"name\": \"Software Sample\", \"projectTypeKey\": \"software\", \"projectTemplateKey\": \"com.pyxis.greenhopper.jira:gh-scrum-template\", \"description\": \"Example Project description\", \"lead\": \"zeenwang7\", \"assigneeType\": \"PROJECT_LEAD\", \"avatarId\": 10200 }";
        response = RestAssured.given()
                .auth().preemptive().basic("zeenwang7", "970227")
                .contentType(ContentType.JSON)
                .body(requestBody)
                .post("http://localhost:8080/rest/api/2/project");
        projectId = response.jsonPath().getString("id");
    }

    @Then("the project should be created successfully")
    public void verifyProjectCreation() {
        response.then().log().body().statusCode(201); // Assuming 201 is the status code for successful creation
    }

    @Then("I apply an existing permission scheme")
    public void applyPermissionScheme() {
        String requestBody = "{ \"id\": \"10000\" }";
        response = RestAssured.given()
                .auth().preemptive().basic("zeenwang7", "970227")
                .contentType(ContentType.JSON)
                .body(requestBody)
                .put("http://localhost:8080/rest/api/2/project/" + projectId + "/permissionscheme");
    }

    @Then("the permission scheme should be applied successfully")
    public void verifyPermissionSchemeApplication() {
        response.then().log().body().statusCode(200); // Assuming 201 is the status code for successful creation
    }

    @Test
    public void testCreateScrumProject() {
        loggedInAsAdminUser();
        createScrumProject();
        verifyProjectCreation();
        applyPermissionScheme();
        verifyPermissionSchemeApplication();
    }

}