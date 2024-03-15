package StepDefs;

import API.GroupAPI;
import Drivers.DriverFactory;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.openqa.selenium.WebDriver;


public class GroupManageAPI {
    private final WebDriver driver;
    private final GroupAPI groupAPI;

    private Response response;

    public GroupManageAPI() {
        driver = DriverFactory.getDriver();
        groupAPI = new GroupAPI();
    }

    @When("I create group with name as {string}")
    public void iCreateGroupWithNameAs(String groupName) {
        response = groupAPI.createGroup(groupName);
    }

    @Then("The group should be created successfully")
    public void theGroupShouldBeCreatedSuccessfully() {
        response.then().statusCode(201);
    }
}
