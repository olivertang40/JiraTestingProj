package stepDef;

import API.GroupAPI;
import constants.URL;
import drivers.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import page_object_model.AdminPO;
import page_object_model.HomePO;


public class GroupManageStepDefs {
    private final WebDriver driver;
    private final GroupAPI groupAPI;

    private Response response;
    public GroupManageStepDefs(){
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
