package StepDefs;

import API.GroupAPI;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.testng.Assert;


public class AddUserToGroupAPI {
    private final GroupAPI groupAPI;

    private Response response;

    public AddUserToGroupAPI() {
        groupAPI = new GroupAPI();
    }

    @When("I add a user to the new group")
    public void i_add_a_user_to_the_current_project() {
        response = groupAPI.addUserToGroup();
    }

    @Then("the user should be added to the group successfully")
    public void the_user_should_be_added_to_group_successfully() {
        Assert.assertEquals(response.jsonPath().getString("name"), "test");
    }




}
