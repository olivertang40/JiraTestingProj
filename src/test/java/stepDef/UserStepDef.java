package stepDef;

import constants.URL;
import drivers.DriverFactory;
import entity.User;
import api.UserAPI;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import org.junit.Assert;
import io.restassured.path.json.JsonPath;
import page_object_model.HomePO;

import java.util.List;

import static io.restassured.RestAssured.given;


public class UserStepDef {

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
        String username = "sliang";
        String password = "gqgx815";

       response = RestAssured.given()
                .auth().preemptive().basic(username, password)
                .contentType("application/json")
                .body(requestBody)
                .post("http://localhost:8080/rest/api/2/user");

        // Validate the response
        response.then().log().body().statusCode(200);
    }

    @Then("The user should be created successfully")
    public void theUserShouldBeCreatedSuccessfully() {
        response.then().log().body().statusCode(201);
    }

    @When("I deactivate the user {string}")
    public void iDeactivateTheUser(String userName) {

        String username = "sliang";
        String password = "gqgx815";

        // Send a request to deactivate the user
        response = RestAssured.given()
                .auth().preemptive().basic(username, password)
                .contentType("application/json")
                .queryParam("username", userName)
                .log().all()
                .body("{\"active\":false}")
                .put("http://localhost:8080/rest/api/2/user");

        // Validate the response
        response.then().log().body().statusCode(200);

    }

    @Then("The user status should be false")
    public void theUserStatusShouldBeFalse() {
        RestAssured.baseURI = "http://localhost:8080";

        // Send a request to check user status
        response = RestAssured.given()
                .auth().preemptive().basic("sliang","gqgx815")
                .contentType(ContentType.JSON)
                .queryParam("username", "charlie")
                .get("/rest/api/2/user");

        // Validate the response
        response.then().log().all().statusCode(200);

        //assert
        Assert.assertEquals("false",response.jsonPath().getString("active"));
    }


    @When("I update current user group to test")
    public void iUpdateCurrentUserGroupToTest() {
        RestAssured.baseURI = "http://localhost:8080";

        // update charlie to group test
        response = RestAssured.given()
                .auth().preemptive().basic("sliang","gqgx815")
                .contentType("application/json")
                .queryParam("groupname", "test")
                .when()
                .body("{\"name\":\"charlie\"}")
                .post("/rest/api/2/group/user");

        // Validate the response
        response.then().log().body().statusCode(200);
    }

    @Then("I find user in the group")
    public void iFindUserInTheGroup() {
        RestAssured.baseURI = "http://localhost:8080";

        // find user in test group
        response = RestAssured.given()
                .auth().preemptive().basic("sliang","gqgx815")
                .contentType("application/json")
                .get("/rest/api/2/group/member");

        // Validate the response
        response.then().statusCode(200);

        //assert
        String name = response.jsonPath().getString("values[0].name");
        Assert.assertEquals("charlie", name);
    }



}
