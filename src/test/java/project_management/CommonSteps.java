package project_management;

import io.cucumber.java.en.Given;
import io.restassured.RestAssured;

public class CommonSteps {
    @Given("I am logged in as an admin user")
    public static void loggedInAsAdminUser() {
        RestAssured.authentication = RestAssured.basic("zeenwang7", "970227");
    }

}
