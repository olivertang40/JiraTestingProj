package StepDefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;


public class UserAPI {

    Response response;

    //create a user with fixed info
    @When("I create a user with info")
    public void iCreateAUserWithInfo() {
        String requestBody = "{\n" +
                "\t\"name\": \"charlie\",\n" +
                "    \"password\": \"charlie\",\n" +
                "    \"emailAddress\":\"charlie@charlie.com\",\n" +
                "    \"displayName\":\"Charlie\",\n" +
                "    \"applicationKeys\":[\n" +
                "        \"jira-software\"\n" +
                "    ]\n" +
                "}";
        String userName = "admin";
        String passWord = "12345";

        response = RestAssured.given()
                .auth().preemptive().basic(userName, passWord)
                .contentType("application/json")
                .body(requestBody)
                .post("http://localhost:8080/rest/api/2/user");

        //Validate the response
        response.then().statusCode(201);
    }

    @Then("The user should be created successfully")
    public void theUserShouldBeCreatedSuccessfully() {
        response.then().statusCode(201);
    }

    @When("I deactivate the user {string}")
    public void iDeactivateTheUser(String userName) {

        String username = "admin";
        String password = "12345";

        // Send a request to deactivate the user
        response = RestAssured.given()
                .auth().preemptive().basic(username, password)
                .contentType("application/json")
                .queryParam("username", userName)
                .body("{\"active\":false}")
                .put("http://localhost:8080/rest/api/2/user");

        // Validate the response
        response.then().statusCode(200);

    }

    @Then("The user status should be false")
    public void theUserStatusShouldBeFalse() {
        RestAssured.baseURI = "http://localhost:8080";

        // Send a request to check user status
        response = RestAssured.given()
                .auth().preemptive().basic("admin", "12345")
                .contentType(ContentType.JSON)
                .queryParam("username", "charlie")
                .get("/rest/api/2/user");

        // Validate the response
        response.then().statusCode(200);

        //assert
        Assert.assertEquals("false", response.jsonPath().getString("active"));
    }


    @When("I update current user group to test")
    public void iUpdateCurrentUserGroupToTest() {
        RestAssured.baseURI = "http://localhost:8080";

        // update charlie to group test
        response = RestAssured.given()
                .auth().preemptive().basic("admin", "12345")
                .contentType("application/json")
                .queryParam("groupname", "test")
                .when()
                .body("{\"name\":\"charlie\"}")
                .post("/rest/api/2/group/user");

        // Validate the response
        response.then().statusCode(201);
    }

    @Then("I find user in the group")
    public void iFindUserInTheGroup() {
        RestAssured.baseURI = "http://localhost:8080";

        // find user in test group
        response = RestAssured.given()
                .auth().preemptive().basic("admin", "12345")
                .contentType("application/json")
                .queryParam("groupname","test")
                .get("/rest/api/2/group/member");

        // Validate the response
        response.then().statusCode(200);

        //assert
        String name = response.jsonPath().getString("values[0].name");
        Assert.assertEquals("charlie", name);
    }
}
